#include<iostream>
using namespace std;

void tes1(){
    int* arr = new int[10];
    for(int i=0; i<20; i++){
        cout<<arr[i]<<" ";
    }
}

void test2(){
        int n; cin>>n;
        vector<int> arr(n);
        for(int i=0; i<arr.size(); i++){
        cin >> arr[i];
    }

    for(int i=0; i<arr.size(); i++){
        cout << arr[i] << " ";
    }
}

void test3(){
    vector<int> arr(10,8);
    for(int i=0; i<arr.size(); i++){
        cout << arr[i] << " ";
    }

}

//Basic Question=================================

int maxEle(vector<int>& arr){
    int max = -1e8;
    for(int i=0; i<arr.size(); i++){
        if(arr[i] > max){
            max = arr[i];
        }
    }
    return max;
}

int minEle(vector<int>& arr){
    int min = 1e8;
    for(int i=0; i<arr.size(); i++){
        if(arr[i] < min){
            min = arr[i];
        }
    }
    return min;
}

int minEle(vector<int>& arr, data){
    int idx = -1;
    for(int i=0; i<arr.size(); i++){
        if(arr[i] == data){
            idx = i;
            break;
        }
    }
    return idx;
}



//MAIN FUNCTION
int main(){
    // test();

    int n;
    cin >> n;
    vector<int> arr(n);
        for(int i=0; i<arr.size(); i++){
        cin >> arr[i];
    }

    return 0;
}