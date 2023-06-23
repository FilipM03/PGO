class KontenerGaz extends Kontener implements Explosible {
    private double pressureLevel;

    public KontenerGaz(double cargoWeight, int height, int length, double maxWeight, double pressureLevel) {
        super(cargoWeight, height, length, maxWeight);
        this.pressureLevel = pressureLevel;}

    public double getPressureLevel() {
        return pressureLevel;}

    @Override
    public void removeCargo() {
        double cargoToKeep = getCargoWeight() * 0.05;
        setCargoWeight(cargoToKeep);}

    @Override
    public void loadCargo(double cargoWeight) throws OverfillException {
        if (cargoWeight > getMaxWeight()) {
            explode();
            throw new OverfillException("Waga kontenera została przekroczona!");}

        setCargoWeight(cargoWeight);}

    @Override
    public void explode() {
        System.out.println("Kontener z gazem o numerze: " + getSerialNumber() + " eksplodował!");}
}
