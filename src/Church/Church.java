package Church;

public class Church {
	private int Parish;
	private String ministry;
	private String date;
	private String name;
	private int age;
	private String gender;
	private String job;
	private String phone;
	
	public Church(int parish, String ministry, String date, String name, int age, String gender, String job, String phone) {
		this.Parish = parish;
		this.ministry = ministry;
		this.date = date;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.job = job;
		this.phone = phone;
	}

	

	public int getParish() {
		return Parish;
	}



	public void setParish(int parish) {
		Parish = parish;
	}



	public String getMinistry() {
		return ministry;
	}



	public void setMinistry(String ministry) {
		this.ministry = ministry;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Parish;
		result = prime * result + age;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((ministry == null) ? 0 : ministry.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Church other = (Church) obj;
		if (Parish != other.Parish)
			return false;
		if (age != other.age)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (ministry == null) {
			if (other.ministry != null)
				return false;
		} else if (!ministry.equals(other.ministry))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}



	public String toString() {
		return  
				"등록일 : " +date+ " / 교구  : " +Parish+ " / 사역자 : " + ministry + 
				"\n이름 : " +name+ " / 또래 : " + age + " / 성별 : "+ gender + " / 직분 : " + job + 
				" \n전화번호 : " + phone;
	}

	
	public String saveSet() {
		return getParish() + "-" + getMinistry() + "-" + getDate() + "-" 
			 + getName() + "-" + getAge() + "-" + getGender() + "-" 
			 + getJob() + "-" + getPhone();
	}
	
	
}