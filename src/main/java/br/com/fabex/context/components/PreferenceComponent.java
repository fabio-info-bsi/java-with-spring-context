package br.com.fabex.context.components;


public class PreferenceComponent {

    private final String module;
    private final String language;
    private final int version;

    public PreferenceComponent(String module, String language, int version) {
        System.out.println("[PreferenceComponent] Initializing ... ");
        this.module = module;
        this.language = language;
        this.version = version;
    }

    @Override
    public String toString() {
        return "PreferenceComponent{" +
                "module='" + module + '\'' +
                ", language='" + language + '\'' +
                ", version=" + version +
                '}';
    }
}
