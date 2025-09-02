import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# Muat dataset
file_path = "StudentsPerformance.csv"
df = pd.read_csv(file_path)

# Scatter plot Math Score vs Reading Score
plt.figure(figsize=(8, 6))
sns.scatterplot(x=df["math score"], y=df["reading score"])
plt.xlabel("Math Score")
plt.ylabel("Reading Score")
plt.title("Scatter Plot: Math Score vs Reading Score")
plt.show()

# Scatter plot Math Score vs Writing Score
plt.figure(figsize=(8, 6))
sns.scatterplot(x=df["math score"], y=df["writing score"])
plt.xlabel("Math Score")
plt.ylabel("Writing Score")
plt.title("Scatter Plot: Math Score vs Writing Score")
plt.show()

# Scatter plot Reading Score vs Writing Score
plt.figure(figsize=(8, 6))
sns.scatterplot(x=df["reading score"], y=df["writing score"])
plt.xlabel("Reading Score")
plt.ylabel("Writing Score")
plt.title("Scatter Plot: Reading Score vs Writing Score")
plt.show()

# Hitung korelasi antara variabel
correlation_matrix = df[["math score", "reading score", "writing score"]].corr(method='pearson')
print("Correlation Matrix:")
print(correlation_matrix)

# Bar chart rata-rata skor berdasarkan jenis kelamin
plt.figure(figsize=(8, 6))
df.groupby("gender")[["math score", "reading score", "writing score"]].mean().plot(kind='bar', stacked=True)
plt.xlabel("Gender")
plt.ylabel("Average Score")
plt.title("Average Scores by Gender")
plt.legend(title="Subjects")
plt.show()  

# Bar chart rata-rata skor berdasarkan ras/etnisitas
plt.figure(figsize=(8, 6))
df.groupby("race/ethnicity")[["math score", "reading score", "writing score"]].mean().plot(kind='bar', stacked=True)
plt.xlabel("Race/Ethnicity")
plt.ylabel("Average Score")
plt.title("Average Scores by Race/Ethnicity")
plt.legend(title="Subjects")
plt.show()

# Bar chart rata-rata skor berdasarkan tingkat pendidikan orang tua
plt.figure(figsize=(10, 6))
df.groupby("parental level of education")[["math score", "reading score", "writing score"]].mean().plot(kind='bar', stacked=True)
plt.xlabel("Parental Level of Education")
plt.ylabel("Average Score")
plt.title("Average Scores by Parental Education Level")
plt.legend(title="Subjects")
plt.xticks(rotation=45)
plt.show()

# Pie chart distribusi gender
plt.figure(figsize=(6, 6))
df['gender'].value_counts().plot.pie(autopct='%1.1f%%', startangle=90, cmap='coolwarm')
plt.ylabel('')
plt.title('Gender Distribution')
plt.show()

# Box-whisker plot melihat distribusi dan outlier
plt.figure(figsize=(8, 6))
sns.boxplot(data=df[["math score", "reading score", "writing score"]])
plt.xlabel("Subjects")
plt.ylabel("Scores")
plt.title("Box Plot of Scores in Different Subjects")
plt.show()


# Laporan Analisis Data Siswa

# 1. Hubungan Antar Variabel
# Berdasarkan scatter plot yang dibuat:
# Terdapat korelasi positif antara nilai matematika dan nilai membaca, serta antara nilai matematika dan nilai menulis. Siswa dengan nilai matematika tinggi cenderung memiliki nilai membaca dan menulis yang tinggi.
# Hubungan antara nilai membaca dan menulis juga menunjukkan korelasi yang kuat, yang berarti siswa yang baik dalam membaca juga cenderung memiliki nilai tinggi dalam menulis.

# 2. Korelasi Antar Variabel
# Hasil perhitungan matriks korelasi menunjukkan bahwa:
# Nilai membaca dan nilai menulis memiliki korelasi tertinggi dibandingkan dengan nilai matematika.
# Korelasi antara nilai matematika dan nilai membaca/menulis masih cukup kuat, meskipun tidak sekuat antara membaca dan menulis.

# 3. Perbedaan Berdasarkan Gender
# Dari bar chart rata-rata skor berdasarkan gender:
# Siswa perempuan cenderung memiliki nilai lebih tinggi dalam membaca dan menulis dibandingkan siswa laki-laki.
# Sementara itu, siswa laki-laki memiliki rata-rata nilai matematika yang sedikit lebih tinggi dibandingkan siswa perempuan.

# 4. Distribusi dan Outlier
# Berdasarkan box plot:
# Distribusi nilai matematika, membaca, dan menulis menunjukkan adanya beberapa outlier, terutama pada nilai yang lebih rendah.
# Rentang nilai membaca dan menulis lebih sempit dibandingkan dengan nilai matematika, menunjukkan bahwa variasi nilai matematika lebih besar.

# 5. Faktor Demografis Lainnya
# Dari analisis rata-rata skor berdasarkan ras/etnisitas, terlihat adanya variasi skor antar kelompok.
# Siswa dengan orang tua yang memiliki tingkat pendidikan lebih tinggi cenderung memiliki rata-rata skor yang lebih baik dalam ketiga mata pelajaran.
