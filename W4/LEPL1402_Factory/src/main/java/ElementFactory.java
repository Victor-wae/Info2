public class ElementFactory extends Factory {

    private static final ElementFactory actual = new ElementFactory();
    private ElementFactory(){}

    public static ElementFactory getInstance() {
        return actual;
    }

    @Override
    LevelComponent getElement(char c) {
        switch (c){
            case '-' : return new Floor();
            case '#' : return new Wall();
            case 'D' : return new Door();
            case 'K' : return new Key();
            default:
                throw new IllegalArgumentException("Pas valide");
        }
    }
}


