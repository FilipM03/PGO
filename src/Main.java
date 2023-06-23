interface Explosible {
    void explode();}
class OverfillException extends Exception {
    public OverfillException(String message) {
        super(message);}
}

public class Main {
    public static void main(String[] args) {
        StatekKontenerowy StatekKontenerowy1 = StatekKontenerowy.createContainerShip(65);
        KontenerCiecz kontenerCiecz = new KontenerCiecz(1800, 4, 10, 3000, false);
        KontenerGaz kontenerGaz = new KontenerGaz(1500, 4, 11, 2500, 4);
        KontenerChlodniczy kontenerChlodniczy = new KontenerChlodniczy(2000, 4, 9, 3000, -15);
        StatekKontenerowy1.addContainer(kontenerCiecz);
        StatekKontenerowy1.addContainer(kontenerGaz);
        StatekKontenerowy1.addContainer(kontenerChlodniczy);
        StatekKontenerowy StatekKontenerowy2 = StatekKontenerowy.createContainerShip(75);
        System.out.println();
        System.out.println("Aktualna ilość kontenerów na statku 1: " + StatekKontenerowy1.getContainers().size());
        System.out.println("Aktualna ilość kontenerów na statku 2: " + StatekKontenerowy2.getContainers().size());
        System.out.println();
        StatekKontenerowy.transferContainers(StatekKontenerowy1, StatekKontenerowy2, StatekKontenerowy1.getContainers());
        System.out.println();
        System.out.println("Ilość kontenerów na statku nr.1 po transferze: " + StatekKontenerowy1.getContainers().size());
        System.out.println("Ilość kontenerów na statku nr.2 po transferze: " + StatekKontenerowy2.getContainers().size());
        StatekKontenerowy2.getContainers().clear();
        System.out.println();
        System.out.println("Wszystkie kontenery ze statku nr.2 zostały usunięte.");}
}

