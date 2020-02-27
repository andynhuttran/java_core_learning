package com.javalearning.multithread.folk_join;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RecursiveTask;

public class CalculateFileSizeTask extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File file;
	
	public CalculateFileSizeTask(String filePath) {
		this(new File(filePath));
	}
	
	public CalculateFileSizeTask(File file) {
		this.file = Objects.requireNonNull(file, "File is null");
	}
	
	@Override
	protected Long compute() {
		
		if (file.isFile()) {
			return file.length();
		}
		
		List<CalculateFileSizeTask> tasks = new ArrayList<CalculateFileSizeTask>();		
		for (File subFile : file.listFiles()) {
			CalculateFileSizeTask task = new CalculateFileSizeTask(subFile);
			task.fork();
			tasks.add(task);
		}
		
		long result = 0;
		for (CalculateFileSizeTask task : tasks) {
			result += task.join();
		}
		
		return result;
	}

	
	
}
