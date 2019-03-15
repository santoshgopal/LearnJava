package abstractClass;

public class Linux extends OS {

	public void ui() {
		System.out.println("Linux is based on: ");
		System.out.println("GUI");
		System.out.println("Terminal");
		System.out.println("Shell");
	}

	public void types() {
		System.out.println("It is based on multi user and multi tasking");
		System.out.println("Linux Architechtures: ");
		System.out.println("32bits and 64bits");
		System.out.println("Types of Linux Distro: ");
		System.out.println("    Kali    ");
		System.out.println("   Ubuntu   ");
		System.out.println("    BOSS    ");
		System.out.println("  Open SUSE ");
		System.out.println("  Red Hat   ");
		System.out.println("   Fedora   ");
		System.out.println("    Arch    ");
		System.out.println("    Mint    ");
	}

	public void purpose() {
		System.out.println("Linux was not designed with some specific purpose in mind");
		System.out.println("but now serves as a reliable open-source and free operating system for: ");
		System.out.println("desktops, servers, mobile phones, lot of IoT devices and embedded devices.");
	}
}