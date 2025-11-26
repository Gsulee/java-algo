void main() {
    Scanner scanner = new Scanner(System.in);
    Algorithm algorithm = new Algorithm();

    int[] numbs = new int[1000000];
    int user;
    int choice;

    for(int i = 0; i < numbs.length; i++){
        numbs[i] = i;
    }

    IO.println("*********************************");
    IO.println("Welcome to the algorithm program.");
    IO.println("*********************************");

    IO.print("Enter a choice (1 - Linear / 2 - Binary): ");
    choice = scanner.nextInt();

    if(choice == 1){

        IO.print("Enter the number you want to search for: ");
        user = scanner.nextInt();

        int index = algorithm.linearSearch(numbs, user);

        if(index != -1){
            IO.println("Found: "+ index);
        }else{
            IO.println("not found");
        }
    }else if(choice == 2){
        IO.print("Enter the number you want to search for: ");
        user = scanner.nextInt();

        int index = algorithm.binarySearch(numbs, user);

        if(index != -1){
            IO.println("Found: "+ index);
        }else{
            IO.println("not found");
        }
    }

}




