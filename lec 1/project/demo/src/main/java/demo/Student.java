package demo;

public class Student {
	private int id;

    private String name;

    private float age;

    public Student(){
    	
    }
    
    public Student(boolean data){
    	if (data == true) {
    		id = 1;
    		name = "eslam";
    		age = 25;
    	}
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

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }
}
