package com.fm.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.fm.bean.FarmVillagePlan;
import com.fm.bean.FarmVillagePlanDetail;
import com.fm.service.bean.Device;
import com.fm.service.bean.Farm;
import com.fm.service.bean.FarmVillage;
import com.fm.service.bean.Farmer;

public class ServiceUtil {

	public static FarmVillage convertPOJO(com.fm.bean.FarmVillage f) {
		FarmVillage fn = new FarmVillage();
		try {
			fn.setNoOfFarms(f.getFarms() == null ? 0 : f.getFarms().size());
			fn.setPlanned(f.getFarmVillagePlan() == null ? false : true);
			BeanUtils.copyProperties(fn, f);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fn;
	}

	public static Farm convertPOJO(com.fm.bean.Farm f) {
		Farm fn = new Farm();
		try {
			fn.setFarmerName(f.getFarmer() != null ? f.getFarmer().getFarmerName() : null);
			fn.setFarmVillageName(f.getFarmVillage() != null ? f.getFarmVillage().getName() : null);
			BeanUtils.copyProperties(fn, f);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fn;
	}

	public static Device convertPOJO(com.fm.bean.Device d) {
		Device fn = new Device();
		try {
			BeanUtils.copyProperties(fn, d);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fn;
	}

	public static Farmer convertPOJO(com.fm.bean.Farmer f) {
		Farmer fn = new Farmer();
		try {
			BeanUtils.copyProperties(fn, f);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fn;
	}

	public static List<FarmVillage> convertPOJOListFV(List<com.fm.bean.FarmVillage> fvs) {
		List<FarmVillage> fnew = new ArrayList<FarmVillage>();

		for (com.fm.bean.FarmVillage f : fvs) {
			FarmVillage fn = new FarmVillage();
			fn.setNoOfFarms(f.getFarms() == null ? 0 : f.getFarms().size());
			fn.setPlanned(f.getFarmVillagePlan() == null ? false : true);
			try {
				BeanUtils.copyProperties(fn, f);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fnew.add(fn);
		}
		return fnew;
	}

	public static List<Farmer> convertPOJOListF(List<com.fm.bean.Farmer> fs) {
		List<Farmer> fnew = new ArrayList<Farmer>();

		for (com.fm.bean.Farmer f : fs) {
			Farmer fn = new Farmer();
			try {
				BeanUtils.copyProperties(fn, f);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fnew.add(fn);
		}
		return fnew;
	}

	public static List<Farm> convertPOJOListFm(List<com.fm.bean.Farm> fs) {
		List<Farm> fnew = new ArrayList<Farm>();

		for (com.fm.bean.Farm f : fs) {
			Farm fn = new Farm();
			fn.setFarmerName(f.getFarmer().getFarmerName());
			fn.setFarmVillageName(f.getFarmVillage().getName());
			try {
				BeanUtils.copyProperties(fn, f);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fnew.add(fn);
		}
		return fnew;
	}

	public static List<Device> convertPOJOListD(List<com.fm.bean.Device> fs) {
		List<Device> fnew = new ArrayList<Device>();

		for (com.fm.bean.Device f : fs) {
			Device fn = new Device();
			try {
				BeanUtils.copyProperties(fn, f);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fnew.add(fn);
		}
		return fnew;
	}

	public static com.fm.bean.Farm convertPOJOFmInverse(Farm f) {
		com.fm.bean.Farm fn = new com.fm.bean.Farm();
		try {
			BeanUtils.copyProperties(fn, f);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fn;
	}

	public static Object convertPOJOFvInverse(FarmVillage fv) {
		com.fm.bean.FarmVillage fn = new com.fm.bean.FarmVillage();
		try {
			BeanUtils.copyProperties(fn, fv);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fn;
	}

	public static Object convertPOJODInverse(Device fv) {
		com.fm.bean.Device fn = new com.fm.bean.Device();
		try {
			BeanUtils.copyProperties(fn, fv);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fn;
	}

	/* Map Pojo to Hibernate Methods start here */

	public static FarmVillagePlan convertPOJOInverseFvp(Object f) {
		FarmVillagePlan fn = new FarmVillagePlan();
		try {
			BeanUtils.copyProperties(fn, f);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fn;
	}

	public static FarmVillagePlanDetail convertPOJOInverseFvpd(Object f) {
		FarmVillagePlanDetail fn = new FarmVillagePlanDetail();
		try {
			BeanUtils.copyProperties(fn, f);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fn;
	}

	public static Object convertPOJOFInverse(Farmer f) {
		Farmer fn = new Farmer();
		try {
			BeanUtils.copyProperties(fn, f);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fn;
	}

}
