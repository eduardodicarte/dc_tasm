package br.com.dicarte.seleniummantis.ejb.facade.tabela;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.capgemini.seleniummantis.ejb.enums.EnumMensagemException;
import com.capgemini.seleniummantis.ejb.exceptions.AmbienteSeleniumMantisException;
import com.capgemini.seleniummantis.ejb.exceptions.NegocioSeleniumMantisException;
import com.capgemini.seleniummantis.ejb.model.entidades.ModelIf;
import com.capgemini.seleniummantis.ejb.util.NegocioConstantesIf;

@Stateless
public class TabelaFacadeBean implements TabelaFacadeLocal, TabelaFacadeRemote {

	@PersistenceContext(unitName = NegocioConstantesIf.PERSISTENCE_UNIT)
	private EntityManager	manager;

	@Override
	@SuppressWarnings("unchecked")
	public Collection<ModelIf> obterTodos(ModelIf model) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ModelIf> query = (CriteriaQuery<ModelIf>) builder.createQuery(model.getClass());
		Root<ModelIf> variableRoot = (Root<ModelIf>) query.from(model.getClass());
		query.select(variableRoot);
		return (Collection<ModelIf>) manager.createQuery(query).getResultList();
	}

	@Override
	public ModelIf gravarAtualizar(ModelIf model) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException {
		if (model.getIdentificador() == null) {
			manager.persist(model);
		} else {
			manager.merge(model);
		}

		return model;
	}

	@SuppressWarnings("unchecked")
	public Collection<ModelIf> obterModelCompleto(ModelIf model) {
		Predicate predicate = null;
		if (model.getNomeColecoes() != null) {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<ModelIf> query = (CriteriaQuery<ModelIf>) builder.createQuery(model.getClass());
			Root<ModelIf> root = (Root<ModelIf>) query.from(model.getClass());
			Collection<Join<ModelIf, ModelIf>> collJoins = obterJoin(model, root);
			Collection<Predicate> collPredicate = new ArrayList<Predicate>();

			for (Join<ModelIf, ModelIf> lJoin : collJoins) {
				collPredicate.add(builder.equal(lJoin.get("identificador"), 0).not());
			}

			for (Predicate lPredicate : collPredicate) {
				if (predicate == null) {
					predicate = lPredicate;
				} else {
					predicate = builder.and(predicate, lPredicate);
				}
			}

			query.select(root).where(predicate);

			return (Collection<ModelIf>) manager.createQuery(query).getResultList();
		}

		return null;
	}

	private Collection<Join<ModelIf, ModelIf>> obterJoin(ModelIf modelIfImpl, Root<ModelIf> rootModel) {
		Collection<Join<ModelIf, ModelIf>> collJoin = new ArrayList<Join<ModelIf, ModelIf>>();
		String[] colecoes = modelIfImpl.getNomeColecoes();
		Join<ModelIf, ModelIf> joins;
		for (String strCollModel : colecoes) {
			joins = rootModel.join(strCollModel, JoinType.LEFT);
			collJoin.add(joins);
		}

		return collJoin;
	}

	@SuppressWarnings("unchecked")
	public ModelIf obterModelUnicoComFiltro(ModelIf model) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException {
		Predicate predicate = null;
		Collection<Field> fldAttr = obterParametros(model);

		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<ModelIf> query = (CriteriaQuery<ModelIf>) builder.createQuery(model.getClass());
			Root<ModelIf> variableRoot = (Root<ModelIf>) query.from(model.getClass());
			Collection<Predicate> collPredicate = new ArrayList<Predicate>();

			for (Field fldAttrRec : fldAttr) {
				collPredicate.add(builder.equal(variableRoot.get(fldAttrRec.getName()), fldAttrRec.get(model)));
			}

			for (Predicate lPredicate : collPredicate) {
				if (predicate == null) {
					predicate = lPredicate;
				} else {
					predicate = builder.and(predicate, lPredicate);
				}
			}
			query.select(variableRoot).where(predicate);

			return (ModelIf) manager.createQuery(query).getSingleResult();

		} catch (Exception exception) {
			if (exception instanceof NegocioSeleniumMantisException) {
				throw new NegocioSeleniumMantisException(((NegocioSeleniumMantisException) exception).getMensagem());
			} else if (exception instanceof NoResultException) {
				throw new NegocioSeleniumMantisException(EnumMensagemException.NENHUM_RESULTADO.getMensagem());
			}

			throw new AmbienteSeleniumMantisException(exception);
		}

	}

	private ArrayList<Field> obterParametros(ModelIf model) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException {
		ArrayList<Field> lstAttr = new ArrayList<Field>();
		try {
			for (Field field : model.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				if (!field.getType().isEnum() && !field.getName().contains("serialVersion")) {
					if (field.get(model) != null) {
						lstAttr.add(field);
					}
				}
			}
		} catch (Exception exception) {

			throw new NegocioSeleniumMantisException(exception, EnumMensagemException.ERRO_PARAMETRO.getMensagem());
		}

		return lstAttr;
	}

	@SuppressWarnings("unchecked")
	public Collection<ModelIf> obterModelComFiltro(ModelIf model) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException {
		Collection<Field> fldAttr = obterParametros(model);

		if (fldAttr.size() == 0) {
			return obterTodos(model);
		}

		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<ModelIf> query = (CriteriaQuery<ModelIf>) builder.createQuery(model.getClass());
			Root<ModelIf> variableRoot = (Root<ModelIf>) query.from(model.getClass());
			Collection<Predicate> collPredicate = new ArrayList<Predicate>();

			for (Field fldAttrRec : fldAttr) {
				collPredicate.add(builder.equal(variableRoot.get(fldAttrRec.getName()), fldAttrRec.get(model)));
			}

			for (Predicate lPredicate : collPredicate) {
				query.select(variableRoot).where(lPredicate);
			}

			return (Collection<ModelIf>) manager.createQuery(query).getResultList();

		} catch (Exception exception) {
			if (exception instanceof NegocioSeleniumMantisException) {
				throw new NegocioSeleniumMantisException(((NegocioSeleniumMantisException) exception).getMensagem());
			} else if (exception instanceof NoResultException) {
				throw new NegocioSeleniumMantisException(EnumMensagemException.NENHUM_RESULTADO.getMensagem());
			}

			throw new AmbienteSeleniumMantisException(exception);
		}

	}
}
