/**
 * @author Andra C.
 *
 * <p> Clasa main va contine programul principal. </p>
 * <p> Toate obiectele instantiate vor avea numele "vx", unde x este indicele incepand de la 0. </p>
 */
public class main {
    public static void main(String[] args) {
        Hotel v1 = new Hotel("Unirea", 50, 100);
        Museum v2 = new Museum("Natura", 30);
        Museum v3 = new Museum("Istorie", 50);
        Church v4 = new Church("Sfanta Maria", "ortodoxa");
        Church v5= new Church("Sfantul Iosif", "catolica");
        Restaurant v6 = new Restaurant("Mammamia", "fast food");
    }
}
