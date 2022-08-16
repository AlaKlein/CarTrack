import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Klein
 */
public class CarTrack {

    /**
     * @param args the command line arguments
     */
    static int degrees = 0;
    static int x = 0;
    static int y = 0;
    static JLabel car;

    public static void turnLeft(int degree) {
        while (degrees != degree) {
            degrees -= 5;
            car.repaint();
            System.out.println(degrees);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public static void turnRight(int degree) {
        while (degrees != degree) {
            degrees += 5;
            car.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public static void driveUp(int pos) {
        while (car.getY() != pos) {
            car.setLocation(x, y);
            y -= 1;
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public static void driveLeft(int pos) {
        while (car.getX() != pos) {
            car.setLocation(x, y);
            x -= 1;
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public static void driveDown(int pos) {
        while (car.getY() != pos) {
            car.setLocation(x, y);
            y += 1;
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public static void driveRight(int pos) {
        while (car.getX() != pos) {
            car.setLocation(x, y);
            x += 1;
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Track");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(616, 439));
        frame.pack();
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setSize(600, 400);
        panel.setLayout(null);
        JLabel track = new JLabel(new ImageIcon("track.png"));
        panel.add(track);
        track.setBounds(0, 0, 600, 400);

        ImageIcon icon = new ImageIcon("car.png");
        car = new JLabel(null, icon, JLabel.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.rotate(Math.toRadians(degrees), icon.getIconWidth() / 2, icon.getIconHeight() / 2);
                g2.drawImage(icon.getImage(), 0, 0, null);
            }
        };

        track.add(car);
        car.setBounds(531, 356, 100, 100);
        frame.add(panel);
        frame.setVisible(true);

        x = car.getX();
        y = car.getY();
        while (true) {

            driveUp(25);
            if (car.getY() == 25) {
                turnLeft(-90);
            }

            driveLeft(350);
            if (car.getX() == 350) {
                turnLeft(-180);
            }

            driveDown(170);
            if (car.getY() == 170) {
                turnLeft(-270);
            }

            driveRight(366);
            if (car.getX() == 366) {
                turnRight(-180);
            }

            driveDown(198);
            if (car.getY() == 198) {
                turnLeft(-270);
            }

            driveRight(381);
            if (car.getX() == 381) {
                turnRight(-180);
            }

            driveDown(285);
            if (car.getY() == 285) {
                turnRight(-90);
            }

            driveLeft(265);
            if (car.getX() == 265) {
                turnRight(0);
            }

            driveUp(29);
            if (car.getY() == 29) {
                turnLeft(-90);
            }

            driveLeft(46);
            if (car.getX() == 46) {
                turnLeft(-180);
            }

            driveDown(355);
            System.out.println("FIM");

            break;
        }

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int x = car.getX();
                int y = car.getY();

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    degrees = 0;
                    car.repaint();
                    System.out.println("x = " + x);
                    System.out.println("y = " + y);
                    car.setLocation(x, y - 1);
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    degrees = 270;
                    car.repaint();
                    System.out.println("x = " + x);
                    System.out.println("y = " + y);
                    car.setLocation(x - 1, y);
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    degrees = 90;
                    car.repaint();
                    System.out.println("x = " + x);
                    System.out.println("y = " + y);
                    car.setLocation(x + 1, y);
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    degrees = 180;
                    car.repaint();
                    System.out.println("x = " + x);
                    System.out.println("y = " + y);
                    car.setLocation(x, y + 1);
                }

            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
    }
}
