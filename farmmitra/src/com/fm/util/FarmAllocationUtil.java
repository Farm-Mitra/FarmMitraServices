package com.fm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fm.bean.Crop;

public class FarmAllocationUtil {

	public static List<List<Crop>> getFieldAllocation(Crop[] cropArray, int maxWaterAvailable, int numberOfFarm) {
		int maxTotalWeight = 0;
		int maxTotalLand = 0;
		int maxTotalWeightForLand = 0;

		List<List<Crop>> allList = new ArrayList<>();
		int total = (int) Math.pow(cropArray.length, numberOfFarm);

		Crop[] weightOptimisedCropAlloc = new Crop[numberOfFarm];
		Crop[] landOptimisedCropAlloc = new Crop[numberOfFarm];

		System.out.println(total);

		int[] index = new int[numberOfFarm];
		Arrays.fill(index, 0);

		for (int i = 0; i < total; i++) {
			Crop[] subSets = new Crop[numberOfFarm];
			int currentWaterAvailable = maxWaterAvailable;
			int totalWeight = 0;
			int totalLand = 0;
			for (int j = 0; j < numberOfFarm; j++) {
				if (currentWaterAvailable >= cropArray[index[j]].getWaterConsumption()) {
					subSets[j] = cropArray[index[j]];
					currentWaterAvailable -= cropArray[index[j]].getWaterConsumption();
					totalWeight += cropArray[index[j]].getWeightage();
					totalLand++;
				}

			}
			// allList.add(subSets);
			if ((maxTotalWeight < totalWeight)) {
				maxTotalWeight = totalWeight;
				weightOptimisedCropAlloc = subSets;

			}

			if (maxTotalLand <= totalLand) {

				if (maxTotalLand < totalLand) {
					maxTotalLand = totalLand;
					landOptimisedCropAlloc = subSets;
				}

				if (maxTotalLand == totalLand && maxTotalWeightForLand < totalWeight) {
					maxTotalWeightForLand = totalWeight;
				}

			}

			if (i != (total - 1))
				index = nextIndex(index, numberOfFarm, cropArray.length);

		}

		allList.add(Arrays.asList(weightOptimisedCropAlloc));
		allList.add(Arrays.asList(landOptimisedCropAlloc));

		return allList;
	}

	// Get the index of the next possible combination
	public static int[] nextIndex(int[] index, int maxLength, int siZe) {
		for (int i = (maxLength - 1); i > 0; i--) {
			if (index[i] == (siZe - 1)) {
				index[i] = 0;
				if (index[i - 1] == (siZe - 1)) {
					continue;
				}
				index[i - 1]++;
				break;
			} else {
				index[i]++;
				break;
			}

		}
		return index;
	}

}
