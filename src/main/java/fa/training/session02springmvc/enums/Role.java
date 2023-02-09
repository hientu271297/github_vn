package fa.training.session02springmvc.enums;

public enum Role {
    TRAINER("Trainer"),
    MENTOR("Mentor"),
    CLASS_ADMIN("Class Admin");

    private final String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
