public class Level extends AbstractLevel {

    public Level(String input) {
        // YOUR CODE HERE
        size = input.split("\n").length;
        components = new LevelComponent[size][size];
        ElementFactory factory = ElementFactory.getInstance();

        int c = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (input.charAt(c) != '\n') {
                    components[i][j] = factory.getElement(input.charAt(c));
                }
                c++;
            }
            c++;
        }
    }

    @Override
    public String toString() {
        StringBuilder NewStr = new StringBuilder(size * size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                NewStr.append(getComponents()[i][j].draw());
            }
            NewStr.append('\n');
        }
        return NewStr.toString();
    }

    @Override
    LevelComponent[][] getComponents() {
        return components;
    }

    @Override
    int getSize() {
        return size * size;
    }

    /* Example of level building with this String : String s = "#-K\n-D-\n#-K\n"
     * Gives : LevelComponent[][] componentsObjects = {
     *                                        {new Wall(), new Floor(), new Key()},
     *                                        {new Floor(), new Door(), new Floor()},
     *                                        {new Wall(), new Floor(), new Key()}}
     */


    // YOUR CODE HERE
}
