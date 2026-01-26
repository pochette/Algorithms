package Patterns.SecondAbstractFabric;

public class GUIFabricMacImpl implements GUIFabric{
    @Override
    public Button createButton() {
        return new ButtonMacImpl();
    }

    @Override
    public CheckBox createCheckBox() {
        return new CheckBoxMacImpl();
    }
}
