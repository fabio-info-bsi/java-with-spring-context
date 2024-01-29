package br.com.fabex.context.components;

public class BallComponent {

    private final String name;
    private final String sport;

    public BallComponent(String n, String s) {
        this.name = n;
        this.sport = s;
    }

    public String getName() {
        return name;
    }

    public String getSport() {
        return sport;
    }
}
