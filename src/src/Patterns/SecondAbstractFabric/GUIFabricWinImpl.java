package Patterns.SecondAbstractFabric;

public class GUIFabricWinImpl implements GUIFabric {
    @Override
    public Button createButton() {
        return new ButtonWinImpl();
    }

    @Override
    public CheckBox createCheckBox() {
        return new CheckBoxWinImpl() ;
    }
}
