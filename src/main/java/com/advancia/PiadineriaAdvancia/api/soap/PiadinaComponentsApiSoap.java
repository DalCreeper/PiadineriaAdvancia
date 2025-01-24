package com.advancia.PiadineriaAdvancia.api.soap;

import java.util.Map;
import java.util.Set;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.advancia.PiadineriaAdvancia.model.api.PiadinaComponentsServiceApi;
import com.advancia.PiadineriaAdvancia.model.classes.Dough;
import com.advancia.PiadineriaAdvancia.model.classes.MeatBase;
import com.advancia.PiadineriaAdvancia.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvancia.model.classes.Sauces;
import com.advancia.PiadineriaAdvancia.services.PiadinaComponentsService;

@WebService
public class PiadinaComponentsApiSoap implements PiadinaComponentsServiceApi {
	private PiadinaComponentsService piadinaComponentsService = new PiadinaComponentsService();

	@Override
	public Map<String, Set<Object>> loadComponents() {
		try {
            Map<String, Set<Object>> components = piadinaComponentsService.getPiadinaComponents();
            if(components != null && !components.isEmpty()) {
                return components;
            } else {
                throw new RuntimeException("No components found");
            }
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while loading components", e);
        }
	}

	@Override
	public Dough addDough(@WebParam(name = "newDough") Dough newDough) {
		try {
            piadinaComponentsService.addDough(newDough);
            return newDough;
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while adding dough", e);
        }
	}

	@Override
	public MeatBase addMeatBase(@WebParam(name = "newMeatBase") MeatBase newMeatBase) {
		try {
            piadinaComponentsService.addMeatBase(newMeatBase);
            return newMeatBase;
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while adding meat base", e);
        }
	}

	@Override
	public Sauces addSauces(@WebParam(name = "newSauces") Sauces newSauces) {
		try {
            piadinaComponentsService.addSauces(newSauces);
            return newSauces;
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while adding sauces", e);
        }
	}

	@Override
	public OptionalElements addOptionalElements(@WebParam(name = "newOptionalElement") OptionalElements newOptionalElement) {
		try {
            piadinaComponentsService.addOptionalElements(newOptionalElement);
            return newOptionalElement;
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while adding optional elements", e);
        }
	}

	@Override
	public Dough getDoughById(@WebParam(name = "id") Integer id) {
		if(id == null) {
            throw new IllegalArgumentException("ID must be an integer");
        }
        Dough dough = piadinaComponentsService.getDoughById(id);
        if(dough != null) {
            return dough;
        } else {
            throw new RuntimeException("Dough not found");
        }
	}

	@Override
	public MeatBase getMeatBaseById(@WebParam(name = "id") Integer id) {
		if(id == null) {
            throw new IllegalArgumentException("ID must be an integer");
        }
        MeatBase meatBase = piadinaComponentsService.getMeatBaseById(id);
        if(meatBase != null) {
            return meatBase;
        } else {
            throw new RuntimeException("MeatBase not found");
        }
	}

	@Override
	public Sauces getSaucesById(@WebParam(name = "id") Integer id) {
		if(id == null) {
            throw new IllegalArgumentException("ID must be an integer");
        }
        Sauces sauces = piadinaComponentsService.getSaucesById(id);
        if(sauces != null) {
            return sauces;
        } else {
            throw new RuntimeException("Sauces not found");
        }
	}

	@Override
	public OptionalElements getOptionalElementsById(@WebParam(name = "id") Integer id) {
		if(id == null) {
            throw new IllegalArgumentException("ID must be an integer");
        }
        OptionalElements optionalElements = piadinaComponentsService.getOptionalElementsById(id);
        if(optionalElements != null) {
            return optionalElements;
        } else {
            throw new RuntimeException("Optional Elements not found");
        }
	}

	@Override
	public Dough updateDough(
			@WebParam(name = "id") Integer id,
			@WebParam(name = "updatedDough") Dough updatedDough
	) {
		if(id == null || updatedDough == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        try {
            piadinaComponentsService.updateDough(id, updatedDough);
            return updatedDough;
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while updating dough", e);
        }
	}

	@Override
	public MeatBase updateMeatBase(
			@WebParam(name = "id") Integer id,
			@WebParam(name = "updatedMeatBase") MeatBase updatedMeatBase
	) {
		if(id == null || updatedMeatBase == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        try {
            piadinaComponentsService.updateMeatBase(id, updatedMeatBase);
            return updatedMeatBase;
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while updating meat base", e);
        }
	}

	@Override
	public Sauces updateSauces(
			@WebParam(name = "id") Integer id,
			@WebParam(name = "updatedSauces") Sauces updatedSauces
	) {
		if(id == null || updatedSauces == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        try {
            piadinaComponentsService.updateSauces(id, updatedSauces);
            return updatedSauces;
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while updating sauces", e);
        }
	}

	@Override
	public OptionalElements updateOptionalElements(
			@WebParam(name = "id") Integer id,
			@WebParam(name = "updatedOptionalElements") OptionalElements updatedOptionalElements
	) {
		if(id == null || updatedOptionalElements == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        try {
            piadinaComponentsService.updateOptionalElements(id, updatedOptionalElements);
            return updatedOptionalElements;
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while updating optional elements", e);
        }
	}

	@Override
	public void deleteDough(@WebParam(name = "id") Integer id) {
		try {
            piadinaComponentsService.deleteDough(id);
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while deleting dough", e);
        }
	}

	@Override
	public void deleteMeatBase(@WebParam(name = "id") Integer id) {
		try {
            piadinaComponentsService.deleteMeatBase(id);
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while deleting meat base", e);
        }
	}

	@Override
	public void deleteSauces(@WebParam(name = "id") Integer id) {
		try {
            piadinaComponentsService.deleteSauces(id);
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while deleting sauces", e);
        }
	}

	@Override
	public void deleteOptionalElements(@WebParam(name = "id") Integer id) {
		try {
            piadinaComponentsService.deleteOptionalElements(id);
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while deleting optional elements", e);
        }
	}

	@Override
	public Dough getDoughByType(@WebParam(name = "type") String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    Dough dough = piadinaComponentsService.getDoughByType(type);
	    if(dough != null) {
	        return dough;
	    } else {
	        throw new RuntimeException("Dough not found for type: " + type);
	    }
	}

	@Override
	public MeatBase getMeatBaseByType(@WebParam(name = "type") String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    MeatBase meatBase = piadinaComponentsService.getMeatBaseByType(type);
	    if(meatBase != null) {
	        return meatBase;
	    } else {
	        throw new RuntimeException("MeatBase not found for type: " + type);
	    }
	}

	@Override
	public Sauces getSaucesByType(@WebParam(name = "type") String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    Sauces sauces = piadinaComponentsService.getSaucesByType(type);
	    if(sauces != null) {
	        return sauces;
	    } else {
	        throw new RuntimeException("Sauces not found for type: " + type);
	    }
	}

	@Override
	public OptionalElements getOptionalElementsByType(@WebParam(name = "type") String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    OptionalElements optionalElements = piadinaComponentsService.getOptionalElementsByType(type);
	    if(optionalElements != null) {
	        return optionalElements;
	    } else {
	        throw new RuntimeException("OptionalElements not found for type: " + type);
	    }
	}

	@Override
	public Dough updateDoughByType(@WebParam(name = "type") String type, @WebParam(name = "updatedDough") Dough updatedDough) {
	    if(type == null || type.trim().isEmpty() || updatedDough == null) {
	        throw new IllegalArgumentException("Invalid input: Type must be a non-empty string and updatedDough cannot be null");
	    }
	    try {
	        piadinaComponentsService.updateDoughByType(type, updatedDough);
	        return updatedDough;
	    } catch(Exception e) {
	        throw new RuntimeException("An error occurred while updating dough by type", e);
	    }
	}

	@Override
	public MeatBase updateMeatBaseByType(@WebParam(name = "type") String type, @WebParam(name = "updatedMeatBase") MeatBase updatedMeatBase) {
	    if(type == null || type.trim().isEmpty() || updatedMeatBase == null) {
	        throw new IllegalArgumentException("Invalid input: Type must be a non-empty string and updatedMeatBase cannot be null");
	    }
	    try {
	        piadinaComponentsService.updateMeatBaseByType(type, updatedMeatBase);
	        return updatedMeatBase;
	    } catch(Exception e) {
	        throw new RuntimeException("An error occurred while updating meat base by type", e);
	    }
	}

	@Override
	public Sauces updateSaucesByType(@WebParam(name = "type") String type, @WebParam(name = "updatedSauces") Sauces updatedSauces) {
	    if(type == null || type.trim().isEmpty() || updatedSauces == null) {
	        throw new IllegalArgumentException("Invalid input: Type must be a non-empty string and updatedSauces cannot be null");
	    }
	    try {
	        piadinaComponentsService.updateSaucesByType(type, updatedSauces);
	        return updatedSauces;
	    } catch(Exception e) {
	        throw new RuntimeException("An error occurred while updating sauces by type", e);
	    }
	}

	@Override
	public OptionalElements updateOptionalElementsByType(@WebParam(name = "type") String type, @WebParam(name = "updatedOptionalElements") OptionalElements updatedOptionalElements) {
	    if(type == null || type.trim().isEmpty() || updatedOptionalElements == null) {
	        throw new IllegalArgumentException("Invalid input: Type must be a non-empty string and updatedOptionalElements cannot be null");
	    }
	    try {
	        piadinaComponentsService.updateOptionalElementsByType(type, updatedOptionalElements);
	        return updatedOptionalElements;
	    } catch(Exception e) {
	        throw new RuntimeException("An error occurred while updating optional elements by type", e);
	    }
	}

	@Override
	public void deleteDoughByType(@WebParam(name = "type") String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
	        piadinaComponentsService.deleteDoughByType(type);
	    } catch(Exception e) {
	        throw new RuntimeException("An error occurred while deleting dough by type", e);
	    }
	}

	@Override
	public void deleteMeatBaseByType(@WebParam(name = "type") String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
	        piadinaComponentsService.deleteMeatBaseByType(type);
	    } catch(Exception e) {
	        throw new RuntimeException("An error occurred while deleting meat base by type", e);
	    }
	}

	@Override
	public void deleteSaucesByType(@WebParam(name = "type") String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
	        piadinaComponentsService.deleteSaucesByType(type);
	    } catch(Exception e) {
	        throw new RuntimeException("An error occurred while deleting sauces by type", e);
	    }
	}

	@Override
	public void deleteOptionalElementsByType(@WebParam(name = "type") String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
	        piadinaComponentsService.deleteOptionalElementsByType(type);
	    } catch(Exception e) {
	        throw new RuntimeException("An error occurred while deleting optional elements by type", e);
	    }
	}
	
	@Override
	public String test(@WebParam(name = "message") String message) {
		return "Message test -> " + message + "!";
	}
}