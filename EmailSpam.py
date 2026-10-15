import numpy as np
import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics import accuracy_score, classification_report
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import MultinomialNB

# ==========================================================
# STEP 1: Loading & Cleaning Real Kaggle Data
# ==========================================================
print(" Loading Kaggle dataset...")

try:
    # 'latin-1' encoding prevents crash issues caused by special characters in real text
    df = pd.read_csv("spam.csv", encoding="latin-1")

    # Kaggle's SMS dataset often contains 3 trailing unnamed garbage columns. We drop them.
    df = df.dropna(how="any", axis=1)

    # Standardize column naming conventions
    df.columns = ["Label", "Email_Text"]
except FileNotFoundError:
    print(
        " Error: 'spam.csv' not found! Make sure it is in your current directory."
    )
    exit()

# Convert labels into binary numbers: 'spam' -> 1, 'ham' -> 0
df["Label_Binary"] = df["Label"].map({"spam": 1, "ham": 0})

print(f" Dataset successfully loaded. Total records: {len(df)}")
print(df[["Label", "Email_Text"]].head())
print("\n" + "=" * 50 + "\n")

# ==========================================================
# STEP 2: Feature Extraction & Data Partitioning
# ==========================================================
X = df["Email_Text"]
y = df["Label_Binary"]

# Stratifying the split preserves identical spam/ham ratio across train/test segments
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.20, random_state=42, stratify=y
)

# ==========================================================
# STEP 3: Vectorization (Turning Text to Matrix Data)
# ==========================================================
# min_df=2 ignores rare words appearing only once across the thousands of rows
tfidf_vectorizer = TfidfVectorizer(
    stop_words="english", lowercase=True, min_df=2
)

X_train_tfidf = tfidf_vectorizer.fit_transform(X_train)
X_test_tfidf = tfidf_vectorizer.transform(X_test)

# ==========================================================
# STEP 4: Model Initialization & Fitting
# ==========================================================
model = MultinomialNB()
model.fit(X_train_tfidf, y_train)

# ==========================================================
# STEP 5: Verification & Assessment Metrics
# ==========================================================
y_pred = model.predict(X_test_tfidf)

accuracy = accuracy_score(y_test, y_pred)
print("--- Kaggle Model Evaluation Metrics ---")
print(f"Accuracy Rate: {accuracy * 100:.2f}%\n")
print("Performance Report:")
print(classification_report(y_test, y_pred, target_names=["Ham", "Spam"]))
print("\n" + "=" * 50 + "\n")

# ==========================================================
# STEP 6: Direct Production Testing
# ==========================================================
print("--- Sandbox Testing ---")


def evaluate_live_input(custom_text):
    vectorized_input = tfidf_vectorizer.transform([custom_text])
    outcome = model.predict(vectorized_input)[0]
    return " SPAM ALERT" if outcome == 1 else " CLEAR / HAM"


# Real-time samples
sample_1 = "URGENT! Your mobile number has won a £2,000 bonus cash prize! Call 09061701461 to claim now."
sample_2 = "Hey, just checking in to see if you want to grab coffee later today?"

print(f"Text: '{sample_1}'\nVerdict: {evaluate_live_input(sample_1)}\n")
print(f"Text: '{sample_2}'\nVerdict: {evaluate_live_input(sample_2)}\n")
