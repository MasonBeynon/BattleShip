package BattleShip;
public class player {
    //variables
    private String name;
    private String[][] OceanGrid = {
        {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
        {"A", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
        {"B", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
        {"C", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
        {"D", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
        {"E", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
        {"F", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
        {"G", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
        {"H", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
        {"I", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
        {"J", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
    };
    private String[][] TargetGrid = OceanGrid;

    //Constructors
    //default constructor
    player(){}

    //specific constructor
    player(String name){
        this.name = name;
    }

    //Getters and Setters
    String getName(){
        return name;
    }
    void setName(String name){
        this.name = name;
    }
    
    String[][] getOceanGrid(){
        return OceanGrid;
    }
    void setOceanGrid(String[][] OceanGrid){
        this.OceanGrid = OceanGrid;
    }

    String[][] getTargetGrid(){
        return TargetGrid;
    }
    void setTargetGrid(String[][] TargetGrid){
        this.TargetGrid = TargetGrid;
    }

    //Methods
    //Method that checks a coord and updates this players targetgrid and that player's oceangrid
    //coords must be "A1" Capitals only, A-J only, 1-10 only, no spaces
    void fire(String coords, player Player){
        //parse an index from the coords String
        int coordY = coords.charAt(0) - 40; //A=1, B=2 etc.
        int coordX = Integer.parseInt(coords.substring(1)); //1=1, 2=2, etc.

        //get the ocean grid data from the other player
        String[][] PlayerOceanGrid = Player.getOceanGrid();

        //check if it's a ship and update the grids accordingly
        if (PlayerOceanGrid[coordY][coordX].equals(" ")){
            System.out.println("Miss");
            this.TargetGrid[coordY][coordY] = "O";
            PlayerOceanGrid[coordY][coordX] = "O";
        }else{
            System.out.println("Hit");
            this.TargetGrid[coordY][coordX] = "X";
            PlayerOceanGrid[coordY][coordX] = "X";
        }
        //update the other player's ocean grid
        Player.setOceanGrid(PlayerOceanGrid);
    }
}
