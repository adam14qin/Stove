
public enum Setting {
	OFF("---"),
	LOW("--+"),
	MEDIUM("-++"),
	HIGH("+++");

	private final String text;

	private Setting(String text) {
		this.text = text;
	}

	public String toString(){
		return text;
	}

}
