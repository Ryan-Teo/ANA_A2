
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

	public String getName() {
		return name;
	}

	public String getHairLength() {
		return hairLength;
	}

	public String getGlasses() {
		return glasses;
	}

	public String getFacialHair() {
		return facialHair;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public String getPimples() {
		return pimples;
	}

	public String getHat() {
		return hat;
	}

	public String getHairColor() {
		return hairColor;
	}

	public String getNoseShape() {
		return noseShape;
	}

	public String getFaceShape() {
		return faceShape;
	}
}