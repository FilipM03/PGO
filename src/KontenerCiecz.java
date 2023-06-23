class KontenerCiecz extends Kontener implements Explosible {
    private boolean isDangerous;

    public KontenerCiecz(double cargoWeight, int height, int length, double maxWeight, boolean isDangerous) {
        super(cargoWeight, height, length, maxWeight);
        this.isDangerous = isDangerous;}

    public boolean isDangerous() {
        return isDangerous;}

    @Override
    public void loadCargo(double cargoWeight) throws OverfillException {
        double threshold;

        if (isDangerous) {
            threshold = getMaxWeight() / 2;}
        else {
            threshold = getMaxWeight() * 0.9;}

        if (cargoWeight > threshold) {
            explode();
            throw new OverfillException("Waga kontenera została przekroczona.");}

        setCargoWeight(cargoWeight);}

    @Override
    public void explode() {
        System.out.println("Kontener z cieczą o numerze: " + getSerialNumber() + " eksplodował!");}
}
