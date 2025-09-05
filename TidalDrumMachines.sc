TidalDrumMachines {

	*machinesPath {
		^PathName.new("machines".resolveRelative);
	}

	*loadBanks { |superdirtInstance|
		this.machinesPath.entries.do { |path|
			var folderPaths, folderName;
			folderPaths = path +/+ "/*";
			folderName = path.folderName;

			superdirtInstance.loadSoundFilesToBank(
				paths: folderPaths.fullPath,
				appendToExisting: false,
				bankName: folderName,
				namingFunction: { |x| x.basename.replace("-", "_") }
			);
		};
	}
}
