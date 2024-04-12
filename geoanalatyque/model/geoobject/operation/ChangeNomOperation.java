package model.geoobject.operation;


public class ChangeNomOperation implements Operation{

    /**
     * Donne le titre de l'opération
     *
     * @return le nom de l'opération
     */
    @Override
    public String getTitle() {
        return null;
    }

    /**
     * Donne le nombre d'arguments de l'opération
     *
     * @return le nombre d'argument d'une opération
     */
    @Override
    public int getArite() {
        return 0;
    }

    /**
     * Rajoute un argument à une opération
     *
     * @param num la position de l'argument
     * @param o   le type de l'argument
     */
    @Override
    public void setArgument(int num, Object o) {

    }

    /**
     * Donne la classe d'un argument
     *
     * @param num la position de l'argument
     * @return la classe de l'argument
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Class getClassArgument(int num) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Object calculer() {
        return null;
    }

    /**
     * Donne la description de l'argument
     *
     * @param num la position de l'argument
     * @return la description de l'argument
     */
    @Override
    public String getDescriptionArgument(int num) {
        return null;
    }
}
