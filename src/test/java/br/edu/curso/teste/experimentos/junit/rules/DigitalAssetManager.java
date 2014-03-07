package br.edu.curso.teste.experimentos.junit.rules;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;

import com.google.common.base.Preconditions;

@SuppressWarnings("unused")
public class DigitalAssetManager {

	private File icon;
	private File assets;
	
	public DigitalAssetManager(File icon, File assets) {
		Preconditions.checkNotNull(icon, Messages.ICON_DOESN_EXIST);
		this.icon = icon;
		this.assets = assets;
	}
	
	public int getAssetCount() {		
		if ( assets == null )
			return Constants.NO_ASSETS;
		
		File[] files = assets.listFiles();
		if ( ArrayUtils.isEmpty( files ) )
			return Constants.NO_ASSETS;
		
		return files.length; 
	}
	
	public void createAssets(int numberOfAssets) throws IOException {
		for (int index = 0; index < numberOfAssets; index++) {
			File asset = new File(assets, String.format("asset-%d.mpg", index));
			Assert.assertTrue("Asset couldn't be created.",
					asset.createNewFile());
		}
	}
	
	interface Constants {
		int NO_ASSETS = 0;
	}
	
	interface Messages {
		String ICON_DOESN_EXIST = "Icon is null, not a file, or doesn't exist.";
	}
	
}