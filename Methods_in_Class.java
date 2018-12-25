class Methods_in_Class {
	
	public static void main(String[] args) {
		String name = "Khoo Zheng Jie, Anthony";
		String national = "Republic of Singapore";
		String dob = "20 April, 1996";
		
		String[] hobby = {
			"I like to play basketball",
			"Learning new skills, such as website design",
			"Enjoy going outdoors"
		};
		
		String[] wish = {
			"I wish to get top scores in my education",
			"Develop my programming skills to be self sustainable",
			"Make sure that time spent was spent meaningfully"
		};
		
		
		System.out.printf("My Information");
		Description(name, national, dob);
		hobbies(hobby);
		wishes(wish);		

	}
	
	public static void Description(String name, String national, String dob) {
		
		System.out.printf("%nName: %s%nNational: %s%nDate of birth: %s%n",
							name,
							national,
							dob
						);
		
	}
	
	public static void hobbies (String[] hobby) {
		
		System.out.printf("I have " + hobby.length + " hobbies\n");
		
		for(int i = 0; i<hobby.length; i++) {
			System.out.print("\t" + (i+1) + ": " + hobby[i] + "\n");
		}

	}
	
	public static void wishes (String[] wish) {
		
		System.out.printf("I have " + wish.length + " wishes\n");
		
		for(int j = 0; j<wish.length; j++) {
			System.out.print("\t" + (j+1) + ": " + wish[j] + "\n");
		}

	}
	
	
}