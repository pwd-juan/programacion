package ac4;

public class Planeta extends CuerpoCeleste {
    public Planeta(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
    }

    @Override
    public boolean addSatelite(CuerpoCeleste c) {
        if (c.getTipoCuerpo() == TipoCuerpoCeleste.LUNA) {
            return super.addSatelite(c);
        }
        return false;
    }
}
