package demo;

public class Student {
	private int id;

    private String name;

    private boolean active;

    public Student(){
    	
    }
    
    
    public Student(int id, String name, boolean active) {
		this.id = id;
		this.name = name;
		this.active = active;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
