package characters;

public interface Attackable<T extends Characters> {
    public int attack(T character);
}
