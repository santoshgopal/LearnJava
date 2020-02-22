import java.util.Scanner;
import javax.swing.JOptionPane;

public class GitConsole {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 to Configure git for Linux");
		System.out.println("Press 2 to Push and commit");
		System.out.println("Press 3 to reset build file || not config file");
		System.out.println("Press 4 to fetch Git Connectivity");
		System.out.println("Press 5 to modity, update and delete files from Git repo");
		System.out.println("Press 6 to exit");
		int i = sc.nextInt();
		if (i == 1) {
			String repo_name = JOptionPane.showInputDialog("Enter Respository Name:");
			String user_name = JOptionPane.showInputDialog("Enter user.name:");
			String user_email = JOptionPane.showInputDialog("Enter user.email:");
			String output = ">1 git remote add origin https://github.com/" + repo_name + ".git \n"
					+ ">2 git config --global user.name \"" + user_name + "\" \n"
					+ ">3 git config --global user.email \"" + user_email + "\" \n";
			JOptionPane.showMessageDialog(null, output);
		} else if (i == 2) {

			String repo_name = JOptionPane.showInputDialog("Enter Respository Name:");
			String file_name = JOptionPane.showInputDialog("Enter the file name:");
			String commit_message = JOptionPane.showInputDialog("Enter commit message:");
			String master_branch = JOptionPane.showInputDialog("Enter the branch name:");

			String output = ">1 git add " + file_name + "\n" + ">2 git status  \n" + ">3 git commit -m \""
					+ commit_message + "\" \n" + ">4 git status  \n" + ">5 git push -u origin " + master_branch;
			JOptionPane.showMessageDialog(null, output);

		} else if (i == 3) {
			String output = ">1 git stash  \n";
			JOptionPane.showMessageDialog(null, output);
		} else if (i == 4) {
			String output = "> git pull --rebase origin master  \n";
			JOptionPane.showMessageDialog(null, output);
		} else if (i == 5) {
			String file_name = JOptionPane.showInputDialog("Enter the folder name:");
			String output = ">1 git checkout master  \n" + ">2 git rm -r " + file_name + "\n"
					+ ">3 git commit -m \"unneeded file \" \n" + ">4 git push origin master";
			JOptionPane.showMessageDialog(null, output);
		} else if (i == 6) {
			System.exit(0);
		} else {
			System.out.println("Invalid selection !!! ");
		}
	}
}
