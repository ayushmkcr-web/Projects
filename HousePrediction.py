import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, r2_score

# 1. Generate Synthetic Housing Data
np.random.seed(42)
n_samples = 500

data = {
    'SquareFeet': np.random.randint(800, 3500, n_samples),
    'Bedrooms': np.random.randint(1, 6, n_samples),
    'AgeYears': np.random.randint(0, 50, n_samples)
}
df = pd.DataFrame(data)

# Price formula with random noise
noise = np.random.normal(0, 15000, n_samples)
df['Price'] = (df['SquareFeet'] * 150) + (df['Bedrooms'] * 10000) - (df['AgeYears'] * 1200) + 50000 + noise

# 2. Split Data into Features (X) and Target (y)
X = df[['SquareFeet', 'Bedrooms', 'AgeYears']]
y = df['Price']

# 3. Train/Test Split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# 4. Train Model
model = LinearRegression()
model.fit(X_train, y_train)

# 5. Predict
y_pred = model.predict(X_test)

# 6. Evaluate
rmse = np.sqrt(mean_squared_error(y_test, y_pred))
r2 = r2_score(y_test, y_pred)
print(f"RMSE: ${rmse:.2f}")
print(f"R² Score: {r2:.4f}")

# 7. Visualization using Matplotlib and Seaborn
plt.figure(figsize=(14, 6))

# Plot 1: Actual vs Predicted Prices
plt.subplot(1, 2, 1)
sns.scatterplot(x=y_test, y=y_pred, alpha=0.7, color='b')
plt.plot([y_test.min(), y_test.max()], [y_test.min(), y_test.max()], 'r--', lw=2)  # Perfect prediction line
plt.title('Actual vs. Predicted House Prices')
plt.xlabel('Actual Price ($)')
plt.ylabel('Predicted Price ($)')
plt.grid(True, linestyle='--', alpha=0.6)

# Plot 2: Residual Plot (Errors)
residuals = y_test - y_pred
plt.subplot(1, 2, 2)
sns.histplot(residuals, kde=True, color='purple', bins=20)
plt.axvline(x=0, color='r', linestyle='--')
plt.title('Distribution of Residuals (Errors)')
plt.xlabel('Prediction Error ($)')
plt.ylabel('Count')

plt.tight_layout()
plt.show()
