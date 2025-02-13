package enum1;

enum WorkDay {
	MONDAY(1, "월"), TUESDAY(2, "화"), WEDNESDAY(3, "수"), THURSDAY(4, "목"), FRIDAY(0, "금");

	int number;
	String yoil;

	private WorkDay(int n, String harg) {
		number = n;
		yoil = harg;
	}

	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}

	int num() {
		return number;
	}

	String yoil() {
		return yoil;
	}

}
