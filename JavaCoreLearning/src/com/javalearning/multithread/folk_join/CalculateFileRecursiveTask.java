package com.javalearning.multithread.folk_join;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RecursiveTask;

public class CalculateFileRecursiveTask extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File file;
	
	public CalculateFileRecursiveTask(String filePath) {
		this(new File(filePath));
	}
	
	public CalculateFileRecursiveTask(File file) {
		this.file = Objects.requireNonNull(file, "File is null");
	}
	
	@Override
	protected Long compute() {
		
		if (file.isFile()) {
			return file.length();
		}
		
		List<CalculateFileRecursiveTask> tasks = new ArrayList<CalculateFileRecursiveTask>();		
		for (File subFile : file.listFiles()) {
			CalculateFileRecursiveTask task = new CalculateFileRecursiveTask(subFile);
			task.fork();
			tasks.add(task);
		}
		
		long result = 0;
		for (CalculateFileRecursiveTask task : tasks) {
			result += task.join();
		}
		
		return result;
	}

	
	
}
