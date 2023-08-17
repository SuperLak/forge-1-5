package net.kal.tutorialmod.capability;

public interface IManaCapability {

    void consume(float points);
    void fill(float points);
    void set(float points);

    float getMana();

}
