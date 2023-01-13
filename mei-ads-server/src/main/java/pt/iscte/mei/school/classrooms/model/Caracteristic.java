package pt.iscte.mei.school.classrooms.model;

public enum Caracteristic implements CaracteriscticsAction {

    CLASSROOM_MASTER(1) {
        @Override
        public boolean performAction() {
            return false;
        }
    },
    CLASSROOM_NORMAL(2) {
        @Override
        public boolean performAction() {
            return false;
        }
    };

    private int id;

    Caracteristic(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
