class Solution {
    public void mergeSort(int arr[], int l, int r) {
        
                if (l >= r) return; // ek element ya invalid range hamesha sorted hota hai

                int mid = l + (r - l) / 2;

                mergeSort(arr, l, mid);       // left half sort karo
                mergeSort(arr, mid + 1, r);   // right half sort karo
                merge(arr, l, mid, r);        // dono sorted halves ko merge karo
            }

            public static void merge(int[] arr, int l, int mid, int r) {
                int n1 = mid - l + 1;
                int n2 = r - mid;

                int[] a = new int[n1];
                int[] b = new int[n2];

                int idx = l;
                for (int i = 0; i < n1; i++)
                    a[i] = arr[idx++];
                for (int i = 0; i < n2; i++)
                    b[i] = arr[idx++];

                int i = 0, j = 0, k = l;
                while (i < a.length && j < b.length) {
                    if (a[i] <= b[j]) arr[k++] = a[i++];
                    else arr[k++] = b[j++];
                }
                while (i < a.length) arr[k++] = a[i++];
                while (j < b.length) arr[k++] = b[j++];
            }
        }
        
    