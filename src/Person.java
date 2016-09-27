
public class Person {
	private String name, hairLength, glasses, facialHair, eyeColor, pimples, hat, hairColor, noseShape, faceShape;
	
	Person(	String name,String hairLength, String glasses, String facialHair, String eyeColor, 
					String pimples, String hat, String hairColor, String noseShape, String faceShape){
		this.name = name;
		this.hairLength = hairLength;
		this.glasses = glasses;
		this.facialHair = facialHair;
		this.eyeColor = eyeColor;
		this.pimples = pimples;
		this.hat = hat;
		this.hairColor = hairColor;
		this.noseShape = noseShape;
		this.faceShape = faceShape;
	}

	private String getName() {
		return name;
	}

	private String getHairLength() {
		return hairLength;
	}

	private String getGlasses() {
		return glasses;
	}

	private String getFacialHair() {
		return facialHair;
	}

	private String getEyeColor() {
		return eyeColor;
	}

	private String getPimples() {
		return pimples;
	}

	private String getHat() {
		return hat;
	}

	private String getHairColor() {
		return hairColor;
	}

	private String getNoseShape() {
		return noseShape;
	}

	private String getFaceShape() {
		return faceShape;
	}
	
	public String getAttr(String attr){
		String atrStr = null;
		if(attr.equals("name")){
			atrStr = getName();
		}
		else if(attr.equals("hairLength")){
			atrStr = getHairLength();
		}
		else if(attr.equals("glasses")){
			atrStr = getGlasses();
		}
		else if(attr.equals("facialHair")){
			atrStr = getFacialHair();
		}
		else if(attr.equals("eyeColor")){
			atrStr = getEyeColor();
		}
		else if(attr.equals("pimples")){
			atrStr = getPimples();
		}
		else if(attr.equals("hat")){
			atrStr = getHat();
		}
		else if(attr.equals("hairColor")){
			atrStr = getHairColor();
		}
		else if(attr.equals("noseShape")){
			atrStr = getNoseShape();
		}
		else if(attr.equals("faceShape")){
			atrStr = getFaceShape();
		}
		return atrStr;
	}
}