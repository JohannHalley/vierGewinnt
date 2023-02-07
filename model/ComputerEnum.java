package model;



public enum ComputerEnum {
	EASY(LeichtComputer.INSTANCE),MIDDLE(MittelComputer.INSTANCE);
	@SuppressWarnings("rawtypes")
	Enum e;
	
	private ComputerEnum(@SuppressWarnings("rawtypes") Enum e) {
		this.e = e;
	}

}