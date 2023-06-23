import java.util.ArrayList;
import java.util.List;

class StatekKontenerowy {
    private List<Kontener> containers;
    private double maxSpeed;
    private static int maxContainerCount;

    static {
        int indexNumber = 28597;

        if (indexNumber % 2 == 0) {
            maxContainerCount = indexNumber / 2;}
        else {
            maxContainerCount = indexNumber / 5;}
    }

    public StatekKontenerowy(double maxSpeed) {
        this.containers = new ArrayList<>();
        this.maxSpeed = maxSpeed;}

    public List<Kontener> getContainers() {
        return containers;}

    public double getMaxSpeed() {
        return maxSpeed;}

    public int getMaxContainerCount() {
        return maxContainerCount;}

    public void addContainer(Kontener container) {
        if (containers.size() >= maxContainerCount) {
            System.out.println("Osiągnięto maksymalną ilość kontenerów na statku. Dodanie większej ilości nie jest możliwe.");}
        else {
            containers.add(container);
            System.out.println("Dodano kontener o numerze seryjnym: " + container.getSerialNumber());}
    }

    public void addContainers(List<Kontener> newContainers) {
        int availableSpace = maxContainerCount - containers.size();
        int containersToAdd = Math.min(availableSpace, newContainers.size());

        containers.addAll(newContainers.subList(0, containersToAdd));

        if (containersToAdd > 0) {
            System.out.println("Dodano " + containersToAdd + " kontenerów.");}
        else {
            System.out.println("Osiągnięto maksymalną ilość kontenerów na statku. Dodanie większej ilości nie jest możliwe");}
    }

    public void removeContainer(Kontener container) {
        if (containers.remove(container)) {
            System.out.println("Usunięto kontener o numerze seryjnym: " + container.getSerialNumber());
        } else {
            System.out.println("Kontener o podanym numerze nie znajduje się na statku.");}
    }

    public void removeContainers(List<Kontener> containersToRemove) {
        containers.removeAll(containersToRemove);
        System.out.println("Usunięto " + containersToRemove.size() + " kontenerów.");}

    public void replaceContainer(int position, Kontener newContainer) {
        if (position >= 0 && position < containers.size()) {
            containers.set(position, newContainer);
            System.out.println("Zamieniono kontener na pozycji " + position);
        } else {
            System.out.println("Nieprawidłowa pozycja kontenera.");}
    }

    public static void transferContainers(StatekKontenerowy sourceShip, StatekKontenerowy destinationShip, List<Kontener> containers) {
        if (destinationShip.getContainers().size() + containers.size() > destinationShip.getMaxContainerCount()) {
            System.out.println("Tansport kontenerów nie jest możliwy. Docelowe statki kontenerowe nie mają wystarczającej ilości miejsca.");
        } else {
            int transferredContainers = containers.size();
            destinationShip.getContainers().addAll(containers);
            sourceShip.getContainers().removeAll(containers);
            System.out.println("Przeniesiono " + transferredContainers + " kontenerów na statek docelowy.");}
    }

    public static StatekKontenerowy createContainerShip(double maxSpeed) {
        StatekKontenerowy containerShip = new StatekKontenerowy(maxSpeed);
        System.out.println("Utworzono nowy statek kontenerowy.");
        return containerShip;}
}

