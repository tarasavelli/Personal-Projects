/*
 * The Attack Manager is a class that enables the quick creation of save and setting files. It also enables the user to alter which presets are within the game and
 * can be used by the player. 
 * - Teddy Arasavelli
 */






import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class AttackManager {
	
	//Marcos, for this class to work, you will have to change these fields such that they work with your computer.
	public final String PRESETSFILEPATH = "/Users/teddyarasavelli/eclipse-workspace/BoxingSimulator/src/Presets";
	public final String SETTINGSPATH = "/Users/teddyarasavelli/eclipse-workspace/BoxingSimulator/src/settings.txt";
	
	/*
	 * pre: assumes that that the fileName is within the FOLDERPATH, assumes that file passed in is in standard format (Ex: Line 1: Attack type, Line 2: Attack name)
	 * post: will fill the attacks HashSet will all the attacks that are in the file that corresponds to fileName
	 * 
	 */
	
	public void readSave(Set<Attack> attacks, String fileName) throws FileNotFoundException {
		
		
		File saveFile = null;
		boolean hasFile = false;
		for(File file : new File(PRESETSFILEPATH).listFiles()) {
			if(file.getName().equals(fileName))
				saveFile = file;
				hasFile = true;
		}
		
		
		//writing to HashSet
		attacks.clear();
		
		if(hasFile) {
			Scanner scanFile = new Scanner(saveFile);
			while(scanFile.hasNextLine()) {
				String type = scanFile.nextLine();
				String name = scanFile.nextLine();
				attacks.add(new Attack(type, name));
				
			}
		}
		
		//will throw if the fileName passed in does not correspond to a file.
		else {
			throw new FileNotFoundException();
		}
	}
	
	
	/*
	 * pre: will assume that the fileName is a file that is within the FOLDERPATH directory
	 * post: will fill the file with the types and names of the attacks in HashSet attacks
	 */
	public void createSave(Set<Attack> attacks, String fileName) throws IOException {
		
		File directory = new File(PRESETSFILEPATH);
		File save = new File(directory, fileName);
		
		
		PrintStream printer = new PrintStream(save);
		for(Attack attack : attacks) {
			printer.println(attack.getAttackType());
			printer.println(attack.getAttackName());
		}

				
				
	}
	
	/*
	 * pre - assumes that the settings are passed in accurately and that the settings file exists, will not create a new settings file
	 * post - will print the four settings to the settings file
	 */
	public void saveSettings(int roundLength, int comboLength, int reactionTime, int intensity) throws FileNotFoundException {
		//Reference to settings file
		File settings = new File(SETTINGSPATH);
		
		//printing data to settings file
		PrintStream printSettings = new PrintStream(settings);
		printSettings.println(roundLength);
		printSettings.println(comboLength);
		printSettings.println(reactionTime);
		printSettings.println(intensity);
		
		
		
	}
	
	/*
	 * pre - assumes that the settings file exists
	 * post - returns an array of the settins in order of the passed in variables in saveSettings
	 */
	public int[] loadSettings() throws FileNotFoundException {
		int[] settings = new int[4]; //Will hold roundLength, comboLength, reactionTime, intensity in that order
		
		//Taking the numbers from the file and putting into settings array
		Scanner scanSettings = new Scanner(new File(SETTINGSPATH));
		for(int i = 0; i < settings.length; i++) {
			String line = scanSettings.nextLine();
			int settingNum = new Scanner(line).nextInt();
			settings[i] = settingNum;
		}
		
		return settings;
	}
	
	/*
	 * pre - assumes that the PRESETSFILEPATH is correct and leads to presets directory
	 * post - will delete the specified preset that is passed in from the presets directory
	 */
	public void removePreset(String presetName) {
		//Adding the txt such that the file is findable
		String txtName = presetName + ".txt";
		File[] presets = new File(PRESETSFILEPATH).listFiles();
		
		//deleting the specified preset
		for(int i = 0; i < presets.length; i++) {
			String fileName = presets[i].getName();
			if(fileName.equals(txtName))
				presets[i].delete();
		}
	}
	
	/*
	 * pre - assumes that the PRESETSFILEPATH leads to the correct preset directory
	 * post - will return a set of all the different presets in the directory
	 */
	public TreeSet<String> getPresets() {
		
		TreeSet<String> presetSet = new TreeSet<String>();
		
		//Creating the list of presets within the directory
		File[] presets = new File(PRESETSFILEPATH).listFiles();
		
		//Adding the name of each file without the ".txt" to the Set
		for(File preset : presets) {
			String name = preset.getName();
			String parsedName = name.substring(0, name.length()-4);
			presetSet.add(parsedName);
			
		}
		
		return presetSet;
	}
	
	


}
