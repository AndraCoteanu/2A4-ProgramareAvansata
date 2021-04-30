import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoleSet {
     public List<Role> roluri = new ArrayList<>();
    private int noPlayers;

    //in functie de numarul de jucatori constructorul initializeaza lista cu rolurile necesare
    public RoleSet(int noPlayers) {
        this.noPlayers = noPlayers;
        if(noPlayers == 4) {
            initRol4();
        } else if(noPlayers == 5) {
            initRol5();
        } else if(noPlayers == 6) {
            initRol6();
        } else if(noPlayers == 7) {
            initRol7();
        }
    }

    private void initRol4 () {
        Role r0 = new Role(0,"Renegade", 0);
        Role r1 = new Role(1,"Sheriff", 0);
        Role r2 = new Role(2,"Outlaw", 0);
        Role r3 = new Role(3,"Outlaw", 0);

        roluri.add(r0);
        roluri.add(r1);
        roluri.add(r2);
        roluri.add(r3);

        Collections.shuffle(roluri);
    }

    private void initRol5 () {
        Role r0 = new Role(0,"Renegade", 0);
        Role r1 = new Role(1,"Sheriff", 0);
        Role r2 = new Role(2,"Outlaw", 0);
        Role r3 = new Role(3,"Outlaw", 0);
        Role r4 = new Role(4,"Vice", 0);

        roluri.add(r0);
        roluri.add(r1);
        roluri.add(r2);
        roluri.add(r3);
        roluri.add(r4);

        Collections.shuffle(roluri);
    }

    private void initRol6 () {
        Role r0 = new Role(0,"Renegade", 0);
        Role r1 = new Role(1,"Sheriff", 0);
        Role r2 = new Role(2,"Outlaw", 0);
        Role r3 = new Role(3,"Outlaw", 0);
        Role r4 = new Role(4,"Outlaw", 0);
        Role r5 = new Role(5,"Vice", 0);

        roluri.add(r0);
        roluri.add(r1);
        roluri.add(r2);
        roluri.add(r3);
        roluri.add(r4);
        roluri.add(r5);

        Collections.shuffle(roluri);
    }

    private void initRol7 () {
        Role r0 = new Role(0,"Renegade", 0);
        Role r1 = new Role(1,"Sheriff", 0);
        Role r2 = new Role(2,"Outlaw", 0);
        Role r3 = new Role(3,"Outlaw", 0);
        Role r4 = new Role(4,"Outlaw", 0);
        Role r5 = new Role(5,"Vice", 0);
        Role r6 = new Role(6,"Vice", 0);

        roluri.add(r0);
        roluri.add(r1);
        roluri.add(r2);
        roluri.add(r3);
        roluri.add(r4);
        roluri.add(r5);
        roluri.add(r6);

        Collections.shuffle(roluri);
    }

//    public int chooseRole () {
//        int k = noPlayers - 1;
//        int persona = (int) (Math.random() * noPlayers) + 0;
//        while(roluri.get(persona).getUser() != 0) {
//            persona = (int) (Math.random() * noPlayers) + 0;
//        }
//        return persona;
//    }
}
