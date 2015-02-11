package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Capability;
import entity.InputMethod;
import entity.MCC;
import entity.MNC;
import entity.OS;
import entity.UECapabilityLookup;
import entity.UEType;
import entity.UEVendor;

public class PersistenceUtility implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("mydb"); 	
	
	
	public static void persist(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	public static void remove(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Object merge(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();		
		em.close();
		return entity;
	}

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}
	@SuppressWarnings("unchecked")
	public static List<Capability> findAllCapabilities(){
		EntityManager em = emf.createEntityManager();
		List<Capability> caps = (List<Capability>) 
				em.createNamedQuery("Capability.getAllCapabilities").getResultList();
		em.close();
		
		return caps;
		
	}
	public static int findCapabilityById(String capability){
		EntityManager em = emf.createEntityManager();
		int id;
		Capability cap  = (Capability) 
				em.createNamedQuery("Capability.findCapabilityById").
				setParameter("capability", capability).getSingleResult();
		em.close();
		id = cap.getCapability_id();
		if (id<=0)
			return -1;
		else 
			return id;
	}
	@SuppressWarnings("unchecked")
	public static List<UECapabilityLookup> findAllUECapabilities(){
		EntityManager em = emf.createEntityManager();
		List<UECapabilityLookup> caps = (List<UECapabilityLookup>) 
				em.createNamedQuery("UECapabilityLookup.getAll").getResultList();
		em.close();
		
		return caps;
		
	}
	@SuppressWarnings("unchecked")
	public static List<UEVendor> findAllUEVendors(){
		EntityManager em = emf.createEntityManager();
		List<UEVendor> vendors = (List<UEVendor>) 
				em.createNamedQuery("UEVendor.getAll").getResultList();
		em.close();
		
		return vendors;
		
	}
	public static int findVendorIdByName(String manufacturer){
		EntityManager em = emf.createEntityManager();
		int id;
		UEVendor vendor  = (UEVendor) 
				em.createNamedQuery("UEVendor.findId").
				setParameter("manufacturer", manufacturer).getSingleResult();
		em.close();
		id = vendor.getVendorId();
		if (id<=0)
			return -1;
		else 
			return id;
	}
	@SuppressWarnings("unchecked")
	public static List<UEType> findAllUETypes(){
		EntityManager em = emf.createEntityManager();
		List<UEType> types = (List<UEType>) 
				em.createNamedQuery("UEType.getAll").getResultList();
		em.close();
		
		return types;
		
	}
	public static int findTypeIdByName(String ueType){
		EntityManager em = emf.createEntityManager();
		int id;
		UEType type  = (UEType) 
				em.createNamedQuery("UEType.findId").
				setParameter("ueType", ueType).getSingleResult();
		em.close();
		id = type.getUeId();
		if (id<=0)
			return -1;
		else 
			return id;
	}
	@SuppressWarnings("unchecked")
	public static List<InputMethod> findAllInputMethods(){
		EntityManager em = emf.createEntityManager();
		List<InputMethod> inputs = (List<InputMethod>) 
				em.createNamedQuery("InputMethod.getAll").getResultList();
		em.close();
		
		return inputs;
		
	}
	public static int findInputMethodIdByName(String inputMethod){
		EntityManager em = emf.createEntityManager();
		int id;
		InputMethod input  = (InputMethod) 
				em.createNamedQuery("InputMethod.findId").
				setParameter("inputMethod", inputMethod).getSingleResult();
		em.close();
		id = input.getInputMethodId();
		if (id<=0)
			return -1;
		else 
			return id;
	}
	@SuppressWarnings("unchecked")
	public static List<OS> findAllOS(){
		EntityManager em = emf.createEntityManager();
		List<OS> OSs = (List<OS>) 
				em.createNamedQuery("OS.getAll").getResultList();
		em.close();
		
		return OSs;
		
	}
	public static int findOSIdByName(String OSname){
		EntityManager em = emf.createEntityManager();
		int id;
		OS os  = (OS) 
				em.createNamedQuery("OS.findId").
				setParameter("OSname", OSname).getSingleResult();
		em.close();
		id = os.getOSid();
		if (id<=0)
			return -1;
		else 
			return id;
	}
	@SuppressWarnings("unchecked")
	public static List<MCC> findAllMCC(){
		EntityManager em = emf.createEntityManager();
		List<MCC> mccs = (List<MCC>) 
				em.createNamedQuery("MCC.getAll").getResultList();
		em.close();
		
		return mccs;
		
	}
	public static int findMCCIdByName(String country){
		EntityManager em = emf.createEntityManager();
		int id;
		MCC mcc  = (MCC) 
				em.createNamedQuery("MCC.findId").
				setParameter("country", country).getSingleResult();
		em.close();
		id = mcc.getMmcId();
		if (id<=0)
			return -1;
		else 
			return id;
	}
	@SuppressWarnings("unchecked")
	public static List<MNC> findAllMNC(){
		EntityManager em = emf.createEntityManager();
		List<MNC> mncs = (List<MNC>) 
				em.createNamedQuery("MNC.getAll").getResultList();
		em.close();
		
		return mncs;
		
	}
	public static int findMNCIdByName(String operator){
		EntityManager em = emf.createEntityManager();
		int id;
		MNC mnc  = (MNC) 
				em.createNamedQuery("MNC.findId").
				setParameter("operator", operator).getSingleResult();
		em.close();
		id = mnc.getMncId();
		if (id<=0)
			return -1;
		else 
			return id;
	}
	
}