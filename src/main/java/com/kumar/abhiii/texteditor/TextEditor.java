package com.kumar.abhiii.texteditor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.*;

public class TextEditor extends JFrame implements ActionListener
{
private JTextArea area;
private JScrollPane scpane;
private String text = "";
private int ffontSize=20;
private String ffontName="Consolas";
private ImageIcon logoIcon;
public TextEditor() 
{
super("Text-Editor");
setLayout(new BorderLayout());
logoIcon=new ImageIcon(this.getClass().getResource("/icons/logo_icon.png"));
setIconImage(logoIcon.getImage());

area = new JTextArea();
area.setFont(new Font(ffontName, Font.PLAIN, ffontSize));
// by default word wrap enabled
/*
area.setLineWrap(true);
area.setWrapStyleWord(true);
*/
scpane = new JScrollPane(area); 
scpane.setBorder(BorderFactory.createEmptyBorder());



JMenuBar menuBar = new JMenuBar(); //menubar
JMenu file = new JMenu("File"); //file menu
JMenuItem newdoc = new JMenuItem("New");
newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
newdoc.addActionListener(this);
JMenuItem open = new JMenuItem("Open");
open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
open.addActionListener(this);
JMenuItem save = new JMenuItem("Save");
save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
save.addActionListener(this);
JMenuItem print = new JMenuItem("Print");
print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
print.addActionListener(this);
JMenuItem exit = new JMenuItem("Exit");
exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
exit.addActionListener(this);

JMenu edit = new JMenu("Edit");
JMenuItem copy = new JMenuItem("Copy");
copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
copy.addActionListener(this);
JMenuItem paste = new JMenuItem("Paste");
paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
paste.addActionListener(this);
JMenuItem cut = new JMenuItem("Cut");
cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
cut.addActionListener(this);
JMenuItem selectall = new JMenuItem("Select All");
selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
selectall.addActionListener(this);

JMenu style=new JMenu("Style");
//Word wrap
JCheckBoxMenuItem wordWrap=new JCheckBoxMenuItem("Word wrap");
wordWrap.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
if(wordWrap.isSelected())
{
area.setLineWrap(true);
area.setWrapStyleWord(true);
}
else
{
area.setLineWrap(false);
area.setWrapStyleWord(false);
}
}
});


//font menu item
JMenu customFont=new JMenu("Custom Font");
JMenuItem consolasFont=new JMenuItem("Consolas");
consolasFont.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontName="Consolas";
area.setFont(new Font("Consolas",Font.PLAIN,ffontSize));
}
});
JMenuItem sanSerifFont=new JMenuItem("San Serif");
sanSerifFont.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontName="San Serif";
area.setFont(new Font("San Serif",Font.PLAIN,ffontSize));
}
});
JMenuItem monospacedFont=new JMenuItem("Monospaced");
monospacedFont.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontName="Monospaced";
area.setFont(new Font("Monospaced",Font.PLAIN,ffontSize));
}
});
JMenuItem mvBoliFont=new JMenuItem("Mv Boli");
mvBoliFont.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontName="MV Boli";
area.setFont(new Font("MV Boli",Font.PLAIN,ffontSize));
}
});
JMenuItem timesNewRomanFont=new JMenuItem("Times new roman");
timesNewRomanFont.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontName="Times New Roman";
area.setFont(new Font("Times New Roman",Font.PLAIN,ffontSize));
}
});

//font size sub menu item
JMenu fontSize=new JMenu("Font Size");
JMenuItem size8=new JMenuItem("8");
size8.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontSize=8;
area.setFont(new Font(ffontName,Font.PLAIN,ffontSize));
}
});
JMenuItem size12=new JMenuItem("12");
size12.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontSize=12;
area.setFont(new Font(ffontName,Font.PLAIN,ffontSize));
}
});
JMenuItem size16=new JMenuItem("16");
size16.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontSize=16;
area.setFont(new Font(ffontName,Font.PLAIN,ffontSize));
}
});
JMenuItem size20=new JMenuItem("20");
size20.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontSize=20;
area.setFont(new Font(ffontName,Font.PLAIN,ffontSize));
}
});
JMenuItem size24=new JMenuItem("24");
size24.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontSize=24;
area.setFont(new Font(ffontName,Font.PLAIN,ffontSize));
}
});
JMenuItem size28=new JMenuItem("28");
size28.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontSize=28;
area.setFont(new Font(ffontName,Font.PLAIN,ffontSize));
}
});
JMenuItem size30=new JMenuItem("30");
size30.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
ffontSize=30;
area.setFont(new Font(ffontName,Font.PLAIN,ffontSize));
}
});

//bold font
JCheckBoxMenuItem boldFont=new JCheckBoxMenuItem("Bold Font");
boldFont.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
if(boldFont.isSelected())
{
area.setFont(new Font(ffontName,Font.BOLD,ffontSize));
}
else
{
area.setFont(new Font(ffontName,Font.PLAIN,ffontSize));
}
}
});
//italic font
JCheckBoxMenuItem italicFont=new JCheckBoxMenuItem("Italic Font");
italicFont.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev)
{
if(italicFont.isSelected())
{
area.setFont(new Font(ffontName,Font.ITALIC,ffontSize));
}
else
{
area.setFont(new Font(ffontName,Font.PLAIN,ffontSize));
}
}
});


//submenu items
JMenu theme= new JMenu("Theme");
JMenuItem darkTheme=new JMenuItem("Dark theme");
darkTheme.addActionListener(this);
JMenuItem lightTheme=new JMenuItem("Light theme");
lightTheme.addActionListener(this);
JMenuItem blueTheme=new JMenuItem("Blue theme");
blueTheme.addActionListener(this);
//style menu items
JMenuItem customBackground=new JMenuItem("Custom Background");
customBackground.addActionListener(this);
JMenuItem customForeground=new JMenuItem("Custom Foreground");
customForeground.addActionListener(this);



JMenu about = new JMenu("Help");  
JMenuItem textEditor = new JMenuItem("About Text-Editor");
textEditor.addActionListener(this);



file.add(newdoc);
file.add(open);
file.add(save);
file.addSeparator();
file.add(print);
file.add(exit);

edit.add(copy);
edit.add(paste);
edit.add(cut);
edit.addSeparator();
edit.add(selectall);

customFont.add(consolasFont);
customFont.add(sanSerifFont);
customFont.add(mvBoliFont);
customFont.add(monospacedFont);
customFont.add(timesNewRomanFont);

fontSize.add(size8);
fontSize.add(size12);
fontSize.add(size16);
fontSize.add(size20);
fontSize.add(size24);
fontSize.add(size28);
fontSize.add(size30);

theme.add(darkTheme);
theme.add(lightTheme);
theme.add(blueTheme);

style.add(wordWrap);
style.addSeparator();
style.add(customFont);
style.add(fontSize);
style.add(boldFont);
style.add(italicFont);
style.addSeparator();
style.add(theme);
style.add(customBackground);
style.add(customForeground);

about.add(textEditor);

//main menu
setJMenuBar(menuBar);
menuBar.add(file);
menuBar.add(edit);
menuBar.add(style);
menuBar.add(about);

add(scpane, BorderLayout.CENTER);

//to center windows
int w,h;
w=900;
h=700;
setSize(w,h);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation((d.width/2)-(w/2),(d.height/2)-(h/2));
setVisible(true);
}

public void actionPerformed(ActionEvent ae) 
{

if (ae.getActionCommand().equals("New")) 
{
area.setText("");
} else if (ae.getActionCommand().equals("Open")) {
JFileChooser chooser = new JFileChooser("D:/Java");
chooser.setAcceptAllFileFilterUsed(false); 
FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt"); 
chooser.addChoosableFileFilter(restrict);
	
int result = chooser.showOpenDialog(this);
if(result == JFileChooser.APPROVE_OPTION) {
File file = chooser.getSelectedFile();

try{
System.out.println("File Open");
FileReader reader = new FileReader(file);
BufferedReader br = new BufferedReader(reader);
area.read( br, null );
br.close();
area.requestFocus();
}catch(Exception e){
System.out.print(e);
}
}
} else if(ae.getActionCommand().equals("Save")){
final JFileChooser SaveAs = new JFileChooser();
SaveAs.setApproveButtonText("Save");
int actionDialog = SaveAs.showOpenDialog(this);
if (actionDialog != JFileChooser.APPROVE_OPTION) {
return;
}

File fileName = new File(SaveAs.getSelectedFile() + ".txt");
BufferedWriter outFile = null;
try {
outFile = new BufferedWriter(new FileWriter(fileName));
area.write(outFile);
} catch (IOException e) {
e.printStackTrace();
}
}else if(ae.getActionCommand().equals("Print")){
try{
area.print();
}catch(Exception e){}
}else if (ae.getActionCommand().equals("Exit")) {
System.exit(0);
}else if (ae.getActionCommand().equals("Copy")) {
text = area.getSelectedText();
}else if (ae.getActionCommand().equals("Paste")) {
area.insert(text, area.getCaretPosition());
}else if (ae.getActionCommand().equals("Cut")) {
text = area.getSelectedText();
area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
}else if (ae.getActionCommand().equals("Select All")) {
area.selectAll();
}else if (ae.getActionCommand().equals("Dark theme")) {
area.setBackground(Color.BLACK);
area.setForeground(Color.WHITE);
}else if (ae.getActionCommand().equals("Light theme")) {
area.setBackground(Color.WHITE);
area.setForeground(Color.BLACK);
}else if (ae.getActionCommand().equals("Blue theme")) {
area.setBackground(Color.BLUE);
area.setForeground(Color.YELLOW);
}
else if (ae.getActionCommand().equals("Custom Background")) 
{
JColorChooser jcc=new JColorChooser();
Color color=JColorChooser.showDialog(null,"Pick a background color...",Color.black);
area.setBackground(color);
}
else if (ae.getActionCommand().equals("Custom Foreground")) 
{
JColorChooser jcc=new JColorChooser();
Color color=JColorChooser.showDialog(null,"Pick a font color...",Color.white);
area.setForeground(color);
}
else if (ae.getActionCommand().equals("About Text-Editor")) 
{
String aboutText="<html><big>Text-Editor</big><hr>"
	+"<hr><p align=center>This Project is Prepared by <br>Mahakal Institute of Technology & Management<br>(Computer Science) Students.</p>"
	+"<hr><p align=center><big>Developed by</big><br>Abhishek Parmar</p><hr><html>";

JOptionPane.showMessageDialog(TextEditor.this,aboutText,"About Text-Editor!",JOptionPane.INFORMATION_MESSAGE);

}
}
}
