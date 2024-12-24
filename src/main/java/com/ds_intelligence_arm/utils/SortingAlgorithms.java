
package com.ds_intelligence_arm.utils;
import com.ds_intelligence_arm.storage.model.list_am_DataRecord;

public class SortingAlgorithms {

    public static list_am_DataRecord[] list_am_insertion_sort(list_am_DataRecord[] my_array) {
        int my_array_length = my_array.length;

        for (int i = 1; i < my_array_length; i++) {
            list_am_DataRecord key = my_array[i];
            String keyPrice = key.getPriceInAMD();
            double keyPriceValue = 0;

            if (!keyPrice.equals("")) {
                keyPrice = keyPrice.replace(" ", "").replace("$", "").replace("֏", "");
                keyPriceValue = Double.parseDouble(keyPrice);
            }

            int j = i - 1;

            while (j >= 0) {
                String currentPrice = my_array[j].getPriceInAMD();
                double currentPriceValue = 0;

                if (!currentPrice.equals("")) {
                    currentPrice = currentPrice.replace(" ", "").replace("$", "").replace("֏", "");
                    currentPriceValue = Double.parseDouble(currentPrice);
                }

                if (currentPriceValue > keyPriceValue) {
                    my_array[j + 1] = my_array[j];
                    j--;
                } else {
                    break;
                }
            }

            my_array[j + 1] = key;
        }

        return my_array;
    }
}

