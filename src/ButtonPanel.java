import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * Class ButtonPanel:  holds buttons to pick the current shape and to clear the shapes.
 * @author Barb Ericson
 */
public class ButtonPanel extends JPanel
{  
  private String[] shapeNames; // array of shapes that can be drawn
  private String[] colors;
  private JButton clearButton;  // clear button
  private ShapeIComponent shapeComponent;
  
  /** Constructor
   * @param shapeComponent   the shape component
   */
  public ButtonPanel (ShapeIComponent shapeComponent)
  {
    this.shapeComponent = shapeComponent;
    shapeNames = new String[]{Shape.RECTANGLE, Shape.OVAL, Shape.ARC, Shape.LINE}; // modify this if you add more shapes
    colors = new String[]{ShapeIComponent.RED, ShapeIComponent.BLUE, ShapeIComponent.YELLOW, shapeComponent.GREEN};
    // initialize the panel using the init() private helper method
    init();
  }
  
  /** Private helper method to initialize the panel */
  private void init()
  {
    JButton currButton = null;
    
    for (String name: shapeNames)
    {
      currButton = new JButton(name);
      add(currButton); // add is an INHERITED METHOD from a class in JPanel's inheritance hierarchy!
      currButton.addActionListener(new ActionListener()
      {
        public void actionPerformed (ActionEvent e)
        {
          if (shapeComponent != null)
          {
            shapeComponent.setShape(e.getActionCommand());
          }
        }
      });
    }

    for (String name: colors)
    {
      currButton = new JButton(name);
      add(currButton); // add is an INHERITED METHOD from a class in JPanel's inheritance hierarchy!
      currButton.addActionListener(new ActionListener()
      {
        public void actionPerformed (ActionEvent e)
        {
          if (shapeComponent != null)
          {
            shapeComponent.setColor(e.getActionCommand());
          }
        }
      });
    }
    
    // create the clear button
    clearButton = new JButton("Clear");
    add(clearButton); // add is an INHERITED METHOD from a class in JPanel's inheritance hierarchy!
    clearButton.addActionListener(new ActionListener()
    {
      public void actionPerformed (ActionEvent e)
      {
        if (shapeComponent != null)
        {
          shapeComponent.clearShapes();
        }
      }
    });
  }
}
