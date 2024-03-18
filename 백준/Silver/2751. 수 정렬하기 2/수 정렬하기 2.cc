#include <iostream>
#include "random";

using namespace std;
void MergeSort(int start, int end);

static int N;
vector<int> A(N);
vector<int> B(N);
int main() {

    cin >> N;
    A.resize(N);
    B.resize(N);
    for(int i=0; i<N; i++){
        cin >> A[i];
    }


    MergeSort(0, N-1);

    for(int i=0; i<N; i++){
        cout << A[i] << "\n";
    }

//
//    // 시드 설정
//    std::random_device rd;
//    std::mt19937 gen(rd());
//
//    // 균일 분포 생성
//    std::uniform_int_distribution<int> dis(1, 100);
//
//    for(int i=0; i<N; i++){
//        A[i] = dis(gen);
//    }
//
//    MergeSort(0, N-1);
//
//
//    for(int i=0; i<N; i++){
//        cout << A[i] << " ";
//    }
//    cout << std::endl;

    return 0;
}


void MergeSort(int start, int end){
    if(end - start < 1) return;

    int middle = (start + end) / 2;

    // 분할
    MergeSort(start, middle);
    MergeSort(middle + 1, end);


    // 분할하여 정복한 부분을 B배열에 저장
    for(int i=start; i<end + 1; i++){
        B[i] = A[i];
    }
    // B배열을 확인하면서 합병 (정복)
    int index = start;
    int i = start;
    int j = middle + 1;
    while (i < middle+1 && j < end+1){
        if(B[i] < B[j]){
            A[index++] = B[i++];
        }
        else{
            A[index++] = B[j++];
        }
    }
    // B 배열에 남은 값을 A 배열에 넣는다. (이미 정렬된 상태)
    while (i < middle+1)
    {
        A[index++] = B[i++];
    }
    while (j < end+1){
        A[index++] = B[j++];
    }

}
